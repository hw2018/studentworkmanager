import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.ws.Response;

import org.apache.http.Header;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpUtils {
	public static Logger logger=Logger.getLogger("http:");
	private static CloseableHttpClient httpClient=HttpClients.createDefault();
	private static HttpClientContext context=new HttpClientContext();
	private HttpUtils(){
		
	}
	public static String sendGet(String url){
		CloseableHttpResponse response=null;
		String content=null;
		try{
			HttpGet get=new HttpGet(url);
			
			response=httpClient.execute(get,context);
			HttpEntity entity=response.getEntity();
			content=EntityUtils.toString(entity);
			return content;
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
		return content;
	}
	public static CloseableHttpResponse sendPost(String url,List<NameValuePair> nvps){
		CloseableHttpResponse response=null;
		String content=null;
		Header[] header=null;
		try{
			HttpPost post=new HttpPost(url);
			Header[] headers=post.getAllHeaders();
			/*System.out.println(headers.length);
			for(int i=0;i<headers.length;i++){
				System.out.println("post:"+headers[i].getName()+":"+headers[i].getValue());
			}*/
			post.addHeader("Referer", "http://jwch.fzu.edu.cn/");
			post.addHeader("Connection","keep-alive");
			if(nvps!=null){
				post.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
			}
			
			response=httpClient.execute(post,context);
			System.out.println(response.getStatusLine());
			header=response.getAllHeaders();
			
			
			HttpEntity entity=response.getEntity();
			
			content=EntityUtils.toString(entity);
			
			EntityUtils.consume(entity);
			return response;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(response!=null){
				try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return response;
	}
}
