package com.ssafy.rest.service;

import java.util.List;

import com.ssafy.rest.vo.Board;
import com.ssafy.rest.vo.Comment;

public interface BoardService {
	public List<Board> findAllBoard() throws Exception;
	public List<Comment> findByNo(int no) throws Exception;
	public Board findBoardByNo(int no) throws Exception;
	public Board findById(String id) throws Exception;
	public List<Board> findByContents(String contents) throws Exception;
	public boolean addBoard(Board board) throws Exception;
	public boolean updateBoard(Board board) throws Exception;
	public boolean deleteBoard(int no) throws Exception;
}
