package com.ssafy.rest.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.rest.vo.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO{

	private String ns = "QnAMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean addComment(Comment comment) throws Exception {
		int result = sqlSession.insert(ns+"addComment", comment);
		if(result > 0) return true;
		return false;
	}

	@Override
	public boolean updateComment(Comment comment) throws Exception {
		int result = sqlSession.update(ns+"updateComment", comment);
		if(result > 0) return true;
		return false;
	}

	@Override
	public boolean deleteComment(int no) throws Exception {
		int result = sqlSession.delete(ns+"deleteComment");
		if(result > 0) return true;
		return false;
	}

}
