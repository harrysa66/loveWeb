package com.love.blog.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.Article;
import com.love.blog.vo.ArticleList;
import com.love.blog.vo.ArticleType;
import com.love.util.PropertiesUtil;

@Service
public class ArticleBusiness {
	
	RestTemplate restTemplate = new RestTemplate();

	public List<Article> queryArticlesByDisplay(Map<String, Object> urlMap,String display) {
		List<Article> articles = new ArrayList<Article>();
		String rootUrl = MapUtils.getString(urlMap, "msUrl");
		ArticleType type = new ArticleType();
		type.setDisplay(Integer.parseInt(display));
		ArticleList articlelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryByDisplay.rest", type, ArticleList.class);
		for(Article article : articlelist.getArticleList()){
			article.setUrl(rootUrl+"/article/findArticle/"+article.getId()+".s");
			articles.add(article);
		}
		return articles;
	}

	public Article findArticle(String articleId) {
		Article param = new Article();
		param.setId(articleId);
		Article article = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/findById.rest", param, Article.class);
		return article;
	}
	
	/*public ArticleList queryArticlePage(ArticleType type){
		ArticleList articlelist = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/article/queryByDisplay.rest", type, ArticleList.class);
		return articlelist;
	}*/

}
