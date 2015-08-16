package com.love.blog.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.blog.biz.DaysBusiness;
import com.love.blog.vo.Days;
import com.love.blog.vo.DaysIndex;
import com.love.framework.biz.IndexBusiness;
import com.love.framework.controller.BaseController;

@Controller
@RequestMapping("/days")
public class DaysController extends BaseController{

	private final static Logger log= Logger.getLogger(DaysController.class);
	
	@Resource
	private IndexBusiness indexBusiness;
	
	@Resource
	private DaysBusiness daysBusiness;
	
	@RequestMapping("/query")
	public ModelAndView  queryDays(){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		DaysIndex daysIndex = daysBusiness.queryDaysIndex();
		List<Days> daysList = daysBusiness.queryDays();
		context.put("daysIndex", daysIndex);
		context.put("daysList", daysList);
		log.info("query days finish!");
		return forword("days/query",context); 
	}
}
