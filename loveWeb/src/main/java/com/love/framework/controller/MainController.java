package com.love.framework.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController extends BaseController{
	private final static Logger log= Logger.getLogger(MainController.class);
	
	@RequestMapping("/timeout")
	public void timeout(){
		
	}
	
	@RequestMapping("/index")
	public ModelAndView  main(HttpServletRequest request){
		Map<String,Object>  context = getRootMap();
		
		return forword("index",context); 
	}
	
}
