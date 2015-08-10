package com.love.blog.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.Article;
import com.love.blog.vo.ArticleList;
import com.love.blog.vo.ArticleType;

@Service
public class ArticleBusiness {
	
	RestTemplate restTemplate = new RestTemplate();

	public List<Article> queryArticlesByDisplay(String display) {
		ArticleType type = new ArticleType();
		type.setDisplay(Integer.parseInt(display));
		ArticleList articlelist = restTemplate.postForObject("http://127.0.0.1:8080/loveAdmin/services/article/queryByDisplay.rest", type, ArticleList.class);
		return articlelist.getArticleList();
	}

}
