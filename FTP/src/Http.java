import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicNameValuePair;


public class Http {
	public static Logger logger=Logger.getLogger("http:");
	public CloseableHttpResponse Login(){
		logger.info("¿ªÊ¼Ä£ÄâµÇÂ½-----");
		boolean result=false;
		List<NameValuePair> nvpsList=new ArrayList<NameValuePair>();
		nvpsList.add(new BasicNameValuePair("muser", "221400404"));
		nvpsList.add(new BasicNameValuePair("passwd", "221032"));
		nvpsList.add(new BasicNameValuePair("x", "221032"));
		nvpsList.add(new BasicNameValuePair("y", "221032"));
		CloseableHttpResponse response= HttpUtils.sendPost("http://59.77.226.32/logincheck.asp", nvpsList);		
		return response;
	}

	
}
