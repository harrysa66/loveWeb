package com.love.framework.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.framework.biz.IndexBusiness;
import com.love.framework.vo.Menu;

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
		List<Menu> topMenuList = indexBusiness.initTopMenu(context);
		for(Menu menu : topMenuList){
			System.out.println(menu.getName()+"------->"+menu.getUrl());
		}
		List<Menu> rightMenuList = indexBusiness.initRightMenu();
		context.put("topMenuList", topMenuList);
		context.put("rightMenuList", rightMenuList);
		return forword("index",context); 
	}
	
}
