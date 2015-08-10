package com.love.framework.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.blog.vo.Article;
import com.love.framework.biz.IndexBusiness;

@Controller
public class MainController extends BaseController{
	private final static Logger log= Logger.getLogger(MainController.class);
	
	@Resource
	private IndexBusiness indexBusiness;
	
	@RequestMapping("/timeout")
	public void timeout(){
		
	}
	
	@RequestMapping("/index")
	public ModelAndView  main(HttpServletRequest request){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		List<Article> articles = indexBusiness.queryArticles(context);
		context.put("articles", articles);
		log.info("init index finish!");
		return forword("index",context); 
	}
	
}
