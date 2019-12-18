package com.ssafy.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.repo.BoardDAO;
import com.ssafy.rest.vo.Board;
import com.ssafy.rest.vo.Comment;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public List<Board> findAllBoard() throws Exception {
		return boardDao.findAllBoard();
	}

	@Override
	public List<Comment> findByNo(int no) throws Exception {
		return boardDao.findByNo(no);
	}
	
	@Override
	public Board findBoardByNo(int no) throws Exception {
		return boardDao.findBoardByNo(no);
	}

	@Override
	public Board findById(String id) throws Exception {
		return boardDao.findById(id);
	}

	@Override
	public List<Board> findByContents(String contents) throws Exception {
		return boardDao.findByContents(contents);
	}

	@Override
	public boolean addBoard(Board board) throws Exception {
		return boardDao.addBoard(board);
	}

	@Override
	public boolean updateBoard(Board board) throws Exception {
		return boardDao.updateBoard(board);
	}

	@Override
	public boolean deleteBoard(int no) throws Exception {
		return boardDao.deleteBoard(no);
	}

}
