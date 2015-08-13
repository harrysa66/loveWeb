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

import com.love.blog.biz.ArticleBusiness;
import com.love.blog.vo.Article;
import com.love.framework.biz.IndexBusiness;
import com.love.framework.controller.BaseController;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{
	
	private final static Logger log= Logger.getLogger(ArticleController.class);
	
	@Resource
	private ArticleBusiness articleBusiness;
	
	@Resource
	private IndexBusiness indexBusiness;
	
	@RequestMapping("/queryArticles/{display}")
	public ModelAndView  queryArticles(@PathVariable String display,HttpServletRequest request){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		List<Article> articleList = articleBusiness.queryArticlesByDisplay(context,display);
		context.put("articleList", articleList);
		context.put("display", display);
		log.info("query articles finish!");
		return forword("article/query",context); 
	}
	
	@RequestMapping("/findArticle/{articleId}")
	public ModelAndView  findArticle(@PathVariable String articleId,HttpServletRequest request){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		Article article = articleBusiness.findArticle(articleId);
		context.put("article", article);
		log.info("find article finish!");
		return forword("article/find",context); 
	}

}
