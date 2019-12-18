package com.ssafy.rest.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.rest.vo.Board;
import com.ssafy.rest.vo.Comment;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	private String ns = "QnAMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Board> findAllBoard() throws Exception {
		return sqlSession.selectList(ns+"findAllBoard");
	}

	@Override
	public List<Comment> findByNo(int no) throws Exception {
		return sqlSession.selectList(ns+"findByNo",no);
	}
	
	@Override
	public Board findBoardByNo(int no) throws Exception {
		return sqlSession.selectOne(ns+"findBoardByNo", no);
	}
	
	@Override
	public Board findById(String id) throws Exception {
		return sqlSession.selectOne(ns+"findById", id);
	}

	@Override
	public List<Board> findByContents(String contents) throws Exception {
		return sqlSession.selectList(ns+"findByContents",contents);
	}

	@Override
	public boolean addBoard(Board board) throws Exception {
		int result = sqlSession.insert(ns+"addBoard",board);
		if(result > 0 ) return true;
		return false;
	}

	@Override
	public boolean updateBoard(Board board) throws Exception {
		int result = sqlSession.update(ns+"updateBoard", board);
		if(result > 0 ) return true;
		return false;
	}

	@Override
	public boolean deleteBoard(int no) throws Exception {
		int result = sqlSession.delete(ns+"deleteBoard",no);
		if(result > 0 ) return true;
		return false;
	}

}
