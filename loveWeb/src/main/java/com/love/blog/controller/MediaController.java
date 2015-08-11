package com.love.blog.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.blog.biz.MediaBusiness;
import com.love.blog.vo.MediaGroup;
import com.love.framework.biz.IndexBusiness;
import com.love.framework.controller.BaseController;
import com.love.framework.controller.MainController;

@Controller
@RequestMapping("/media")
public class MediaController extends BaseController{
	
	private final static Logger log= Logger.getLogger(MainController.class);
	
	@Resource
	private MediaBusiness mediaBusiness;
	
	@Resource
	private IndexBusiness indexBusiness;
	
	@RequestMapping("/queryMediaGroups/{display}")
	public ModelAndView  queryMediaGroups(@PathVariable String display,HttpServletRequest request){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		List<MediaGroup> mediaGroupList = mediaBusiness.queryMediaGroupsByDisplay(context,display);
		context.put("mediaGroupList", mediaGroupList);
		context.put("display", display);
		log.info("query mediaGroups finish!");
		return forword("media/queryGroups",context); 
	}

}
