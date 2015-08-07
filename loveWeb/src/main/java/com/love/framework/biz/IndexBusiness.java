package com.love.framework.biz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.ArticleType;
import com.love.blog.vo.ArticleTypeList;
import com.love.framework.vo.Menu;
import com.love.util.HttpXmlClient;

@Service
public class IndexBusiness {

	public List<Menu> initTopMenu() {
		RestTemplate restTemplate = new RestTemplate(); 
		ArticleType type = new ArticleType();
		type.setIsshow("Y");
		String url="http://127.0.0.1:8080/loveAdmin/services/article/queryArticleType.rest";//请求路径
		ArticleTypeList list = restTemplate.postForObject(url, type,ArticleTypeList.class);
		for(ArticleType ty : list.getArticleTypeList()){
			System.out.println(ty.getName());
		}
		return null;
	}

	public List<Menu> initRightMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		/*RestTemplate restTemplate = new RestTemplate(); 
		ArticleType type = new ArticleType();
		type.setIsshow("Y");
		String url="http://127.0.0.1:8080/loveAdmin/services/article/queryArticleType.rest";//请求路径
		ArticleTypeList list = restTemplate.postForObject(url, type,ArticleTypeList.class);
		for(ArticleType ty : list.getArticleTypeList()){
			System.out.println(ty.getName());
		}*/
		/*String url="http://127.0.0.1:8080/loveAdmin/services/article/queryArticleType.rest";//请求路径
		Map<String, String> params = new HashMap<String, String>();  
		params.put("isshow", "Y");  
		String xml = HttpXmlClient.post(url, params); 
		System.out.println(xml);*/
		HttpClient client = new DefaultHttpClient();
		String url="http://127.0.0.1:8080/loveAdmin/services/article/queryArticleType.rest";//请求路径
		HttpPost post = new HttpPost(url);
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();  
        parameters.add(new BasicNameValuePair("isshow", "Y"));  
		
		HttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity,"UTF-8");
		System.out.println(result);
	}

}
