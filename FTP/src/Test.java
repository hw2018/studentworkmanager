import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Test {
	public static Logger logger=Logger.getLogger("http:");
	private static CloseableHttpClient httpClient=HttpClients.createDefault();
	private static HttpClientContext context=new HttpClientContext();
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("开始登陆---");
		Http http=new Http();
		CloseableHttpResponse response=http.Login();

		Header[] header=response.getHeaders("set-cookie");
		String cookie=new String(header[0].getValue()).split(";")[0];	
		Header[] headers=response.getHeaders("Location");
		
	String content=null;
	try{
		//第一次开始重定向--------------------------
		HttpPost post=new HttpPost(headers[0].getValue());
		post.addHeader("Referer", "http://jwch.fzu.edu.cn/");
		post.addHeader("Connection","keep-alive");
		
		CloseableHttpResponse response1=httpClient.execute(post,context);
		System.out.println(response1.getStatusLine());
		logger.info("获取返回头header");
		Header[] headers3=response1.getAllHeaders();
		/*for(int i=0;i<headers3.length;i++){
			System.out.println(headers3[i].getName()+":"+headers3[i].getValue());
		}*/
		Header[] cookies=response1.getHeaders("set-cookie");	
		
		//抓取sessionid
		String first=response1.getHeaders("Location")[0].getValue().split("=")[1];
		String id=first.split("&")[0];
		logger.info(id);
		HttpEntity entity=response1.getEntity();
		content=EntityUtils.toString(entity);
		//System.out.println(content+"\n"+response1.getHeaders("Location")[0].getValue());
		
		//第二次重定向
		post=new HttpPost(response1.getHeaders("Location")[0].getValue());
		post.addHeader("Connection","keep-alive");



		response=httpClient.execute(post,context);
		entity=response.getEntity();
		content=EntityUtils.toString(entity);
		//System.out.println(content);
		
		//获取课表信息
		 post=new HttpPost("http://59.77.226.35/student/xkjg/wdkb/kb_xs.aspx"+"?id="+id);

		 response=httpClient.execute(post,context);
		 logger.info(response.getStatusLine().toString());
		 entity=response.getEntity();
		 content=EntityUtils.toString(entity);
	//	 System.out.println(content);
		 
		 //抓取课表信息
		 Document document=Jsoup.parse(content);
		 Element element=document.getElementById("ContentPlaceHolder1_LB_kb");
		 Elements es=element.getElementsByTag("tr");
		 
		 HashMap<String,Course> kb = new HashMap<String,Course>();//根据课程名保存到hasmap
		 for(int m=1;m<es.size();m=m+2){
		 String[] strings=new String(es.get(m).text()).split(" ");
		 if(strings[0].equals("上午")||strings[0].equals("下午")||strings[0].equals("晚上")){//第一个存在时间的时候真正的课表内容在第三个才出现
			 Course course=new Course();
		 for(int i=3,a=1;i<strings.length;i++,a++){
			 
			// System.out.print(strings[i]+"    ");
			 if(a%5==0){		//因为存在教室以及授课计划等等，当前我们只保存课程名称和教师，所以每到1  4保存为一个课程对象
				kb.put(course.getCourseName(),course);
				 course=new Course();
				 //System.out.println();
			 }
			 if(a%5==1){
				 course.setCourseName(strings[i]);
				// System.out.println(strings[i]);
			 }
			 if(a%5==4){
				 course.setCourseTeacher(strings[i]);
				// System.out.println(strings[i]);
			 }
			 
			 
		 	}
		 }else{
			 Course course=new Course();
			 for(int i=2,a=1;i<strings.length;i++,a++){
				 
				// System.out.print(strings[i]+"    ");
				 if(a%5==0){
					 kb.put(course.getCourseName(),course);
					 course=new Course();
					// System.out.println();
				 }
				 if(a%5==1){
					 course.setCourseName(strings[i]);
					// System.out.println(strings[i]);
				 }
				 if(a%5==4){
					 course.setCourseTeacher(strings[i]);
					 //System.out.println(strings[i]);
				 }
				 
				 
			 	}
		 }
		 }
		/* Elements elements=document.getElementsByTag("Font");
		 for (Element font : elements) {
			  System.out.println(font.text());
			}*/
		 
		 logger.info("输出抓取的课程信息");
		 for(Course course:kb.values()){
			 System.out.println(course.getCourseName()+"    "+course.getCourseTeacher());
		 }
		 
		 
		 Ftp t = new Ftp();      
         
         boolean connecting = t.connect("", "211.80.196.1", 21, "download", "download");      
        System.out.println( "连接 ：" + connecting  );  
      //  t.download("",kb , "C:\\Users\\huangwei\\Desktop");
	}catch(Exception e){
		e.printStackTrace();
		if(response!=null){
			try {
				response.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
	}
}