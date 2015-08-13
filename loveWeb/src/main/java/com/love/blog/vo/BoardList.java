package com.love.blog.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardList")
public class BoardList {
	
	private List<Board> boardList;

	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}

}
