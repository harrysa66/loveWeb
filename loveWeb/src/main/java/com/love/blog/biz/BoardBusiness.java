package com.love.blog.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.love.blog.vo.Board;
import com.love.blog.vo.BoardList;
import com.love.blog.vo.CodeMessgae;
import com.love.framework.common.Constants;
import com.love.util.PropertiesUtil;

@Service
public class BoardBusiness {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public List<Board> queryBoards(){
		List<Board> boards = new ArrayList<Board>();
		Board board = new Board();
		board.setStatus(Constants.STATUS_DEFAULT);
		BoardList boardList = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/board/queryBoards.rest", board, BoardList.class);
		boards.addAll(boardList.getBoardList());
		return boards;
	}

	public CodeMessgae writeBoard(Board board) {
		CodeMessgae codeMessgae = restTemplate.postForObject(PropertiesUtil.getProperty("adminUrl")+"/services/board/writeBoard.rest", board, CodeMessgae.class);
		return codeMessgae;
	}

}
