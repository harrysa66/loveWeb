package com.love.blog.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.framework.biz.IndexBusiness;
import com.love.framework.controller.BaseController;

@Controller
@RequestMapping("/days")
public class DaysController extends BaseController{

	private final static Logger log= Logger.getLogger(DaysController.class);
	
	@Resource
	private IndexBusiness indexBusiness;
	
	@RequestMapping("/query")
	public ModelAndView  queryDays(){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		
		log.info("query days finish!");
		return forword("days/query",context); 
	}
}
