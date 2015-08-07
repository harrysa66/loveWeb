package com.love.util;

import org.springframework.web.client.RestTemplate;

public class RestUtil {
	
	public static <T> Class<T> getResult(Class<T> clazz,Class<T> reClazz,String url){
		RestTemplate restTemplate = new RestTemplate(); 
		return restTemplate.postForObject(url, clazz.getClass(),reClazz.getClass());
	}

}
