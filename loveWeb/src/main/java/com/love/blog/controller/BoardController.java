package com.love.blog.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love.blog.biz.BoardBusiness;
import com.love.blog.vo.Board;
import com.love.blog.vo.CodeMessgae;
import com.love.framework.biz.IndexBusiness;
import com.love.framework.controller.BaseController;
import com.love.util.IPUtil;

@Controller
@RequestMapping("/board")
public class BoardController extends BaseController{
	
	private final static Logger log= Logger.getLogger(BoardController.class);
	
	@Resource
	private BoardBusiness boardBusiness;
	
	@Resource
	private IndexBusiness indexBusiness;
	
	@RequestMapping("/query")
	public ModelAndView  queryArticles(){
		Map<String,Object>  context = getRootMap();
		context.putAll(indexBusiness.initIndex(context));
		List<Board> boardList = boardBusiness.queryBoards();
		context.put("boardList", boardList);
		log.info("query boards finish!");
		return forword("board/query",context); 
	}
	
	@RequestMapping("/writeBoard")
	public void  writeBoard(Board board,HttpServletRequest request,HttpServletResponse response){
		board.setIp(IPUtil.getIpAddr(request));
		CodeMessgae codeMessgae = boardBusiness.writeBoard(board);
		if(codeMessgae.getCode().equals(CodeMessgae.CODE_SUCCESS)){
			sendSuccessMessage(response, codeMessgae.getMessage());
		}else if(codeMessgae.getCode().equals("1001")){
			sendFailureMessage(response, codeMessgae.getMessage());
		}else{
			sendFailureMessage(response, "留言失败");
		}
	}

}
