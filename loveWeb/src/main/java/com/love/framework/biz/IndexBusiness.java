package com.love.framework.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.ArticleType;
import com.love.blog.vo.ArticleTypeList;
import com.love.blog.vo.MediaType;
import com.love.blog.vo.MediaTypeList;
import com.love.framework.common.Constants;
import com.love.framework.vo.Menu;

@Service
public class IndexBusiness {
	
	RestTemplate restTemplate = new RestTemplate();

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
		ArticleTypeList articleTypelist = restTemplate.postForObject("http://127.0.0.1:8080/loveAdmin/services/article/queryArticleType.rest", articleType, ArticleTypeList.class);
		for(ArticleType type : articleTypelist.getArticleTypeList()){
			menu = new Menu();
			menu.setName(type.getName());
			menu.setType(type.getDisplay().toString());
			menu.setUrl(rootUrl+"/article/queryArticles/"+type.getDisplay());
			menus.add(menu);
		}
		//得到媒体类型
		MediaType mediaType = new MediaType();
		mediaType.setIsshow(Constants.ISSHOW_SHOW);
		MediaTypeList mediaTypeList = restTemplate.postForObject("http://127.0.0.1:8080/loveAdmin/services/media/queryMediaType.rest", mediaType, MediaTypeList.class);
		for(MediaType type : mediaTypeList.getMediaTypeList()){
			menu = new Menu();
			menu.setName(type.getName());
			menu.setType(type.getDisplay().toString());
			menu.setUrl(rootUrl+"/media/queryMedias/"+type.getDisplay());
			menus.add(menu);
		}
		//留言板
		menu = new Menu();
		menu.setName("留言板");
		menu.setUrl(rootUrl+"/board/query");
		menus.add(menu);
		return menus;
	}

	public List<Menu> initRightMenu() {
		
		return null;
	}
	
}
