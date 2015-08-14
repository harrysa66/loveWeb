package com.love.framework.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.Article;
import com.love.blog.vo.ArticleList;
import com.love.blog.vo.ArticleType;
import com.love.blog.vo.ArticleTypeList;
import com.love.blog.vo.IndexPage;
import com.love.blog.vo.MediaGroupList;
import com.love.blog.vo.MediaType;
import com.love.blog.vo.MediaTypeList;
import com.love.framework.common.Constants;
import com.love.framework.vo.Menu;
import com.love.util.PropertiesUtil;

@Service
public class IndexBusiness {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public Map<String, Object> initIndex(Map<String, Object> context){
		IndexPage indexPage = queryIndexPage();
		List<Menu> topMenuList = initTopMenu(context);
		List<Menu> articleRightMenuList = initArticleRightMenu(context);
		List<Menu> mediaRightMenuList = initMediaRightMenu(context);
		List<Menu> articleTitleList = initArticleTitle(context);
		context.put("indexPage", indexPage);
		context.put("topMenuList", topMenuList);
		context.put("articleRightMenuList", articleRightMenuList);
		context.put("mediaRightMenuList", mediaRightMenuList);
		context.put("articleTitleList", articleTitleList);
		return context;
	}

	public List<Menu> initTopMenu(Map<String, Object> urlMap) {
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu = null;
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		//网站首页
		menu = new Menu();
		menu.setName("网站首页");
		menu.setUrl(rootUrl);
		menus.add(menu);
		//得到文章类型
		ArticleType articleType = new ArticleType();
		articleType.setIsshow(Constants.ISSHOW_SHOW);
		ArticleTypeList articleTypelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryArticleType.rest", articleType, ArticleTypeList.class);
		if(articleTypelist != null && articleTypelist.getArticleTypeList() != null){
			for(ArticleType type : articleTypelist.getArticleTypeList()){
				menu = new Menu();
				menu.setName(type.getName());
				menu.setType(type.getDisplay().toString());
				menu.setUrl(rootUrl+"/article/queryArticles/"+type.getDisplay()+".s");
				menus.add(menu);
			}
		}
		//得到媒体类型
		MediaType mediaType = new MediaType();
		mediaType.setIsshow(Constants.ISSHOW_SHOW);
		MediaTypeList mediaTypeList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/media/queryMediaType.rest", mediaType, MediaTypeList.class);
		if(mediaTypeList != null && mediaTypeList.getMediaTypeList() != null){
			for(MediaType type : mediaTypeList.getMediaTypeList()){
				menu = new Menu();
				menu.setName(type.getName());
				menu.setType(type.getDisplay().toString());
				menu.setUrl(rootUrl+"/media/queryMediaGroups/"+type.getDisplay()+".s");
				menus.add(menu);
			}
		}
		//留言板
		menu = new Menu();
		menu.setName("留言板");
		menu.setUrl(rootUrl+"/board/query.s");
		menus.add(menu);
		return menus;
	}

	public List<Menu> initArticleRightMenu(Map<String, Object> urlMap) {
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu = null;
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		//得到所有可用文章类型
		ArticleType articleType = new ArticleType();
		articleType.setIsshow(null);
		ArticleTypeList articleTypelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryArticleType.rest", articleType, ArticleTypeList.class);
		if(articleTypelist != null && articleTypelist.getArticleTypeList() != null){
			for(ArticleType type : articleTypelist.getArticleTypeList()){
				menu = new Menu();
				ArticleType tempType = new ArticleType();
				tempType.setId(type.getId());
				ArticleList articlelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryByType.rest", tempType, ArticleList.class);
				if(articlelist.getArticleList() != null){
					menu.setName(type.getName()+"（"+articlelist.getArticleList().size()+"）");
				}else{
					menu.setName(type.getName()+"（0）");
				}
				menu.setType(type.getDisplay().toString());
				menu.setUrl(rootUrl+"/article/queryArticles/"+type.getDisplay()+".s");
				menus.add(menu);
			}
		}
		return menus;
	}

	public List<Menu> initMediaRightMenu(Map<String, Object> urlMap) {
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu = null;
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		//得到所有可用媒体类型
		MediaType mediaType = new MediaType();
		mediaType.setIsshow(Constants.ISSHOW_SHOW);
		MediaTypeList mediaTypeList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/media/queryMediaType.rest", mediaType, MediaTypeList.class);
		if(mediaTypeList != null && mediaTypeList.getMediaTypeList() != null){
			for(MediaType type : mediaTypeList.getMediaTypeList()){
				menu = new Menu();
				MediaType tempType = new MediaType();
				tempType.setId(type.getId());
				MediaGroupList groupList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/media/queryGroupByType.rest", tempType, MediaGroupList.class);
				if(groupList.getMediaGroupList() != null){
					menu.setName(type.getName()+"（"+groupList.getMediaGroupList().size()+"）");
				}else{
					menu.setName(type.getName()+"（0）");
				}
				menu.setType(type.getDisplay().toString());
				menu.setUrl(rootUrl+"/media/queryMediaGroups/"+type.getDisplay()+".s");
				menus.add(menu);
			}
		}
		return menus;
	}

	public List<Menu> initArticleTitle(Map<String, Object> urlMap) {
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu = null;
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		ArticleType articleType = new ArticleType();
		articleType.setId("");
		ArticleList articlelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryByType.rest", articleType, ArticleList.class);
		if(articlelist != null && articlelist.getArticleList() != null){
			for(Article article : articlelist.getArticleList()){
				menu = new Menu();
				menu.setName(article.getTitle());
				menu.setType(article.getTypeId());
				menu.setUrl(rootUrl+"/article/findArticle/"+article.getId()+".s");
				menus.add(menu);
			}
		}
		return menus;
	}

	public IndexPage queryIndexPage() {
		IndexPage indexPage = new IndexPage();
		indexPage.setId(null);
		indexPage = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/indexPage/queryIndex.rest", indexPage, IndexPage.class);
		return indexPage;
	}
	
	public List<Article> queryArticles(Map<String, Object> urlMap){
		List<Article> articles = new ArrayList<Article>();
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		ArticleType articleType = new ArticleType();
		articleType.setId("");
		ArticleList articlelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryByType.rest", articleType, ArticleList.class);
		if(articlelist != null && articlelist.getArticleList() != null){
			for(Article article : articlelist.getArticleList()){
				article.setUrl(rootUrl+"/article/findArticle/"+article.getId()+".s");
				articles.add(article);
			}
		}
		return articles;
	}
	
}
