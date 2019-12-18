package com.ssafy.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.repo.CommentDAO;
import com.ssafy.rest.vo.Comment;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public boolean addComment(Comment comment) throws Exception {
		return commentDAO.addComment(comment);
	}

	@Override
	public boolean updateComment(Comment comment) throws Exception {
		return commentDAO.updateComment(comment);
	}

	@Override
	public boolean deleteComment(int no) throws Exception {
		return commentDAO.deleteComment(no);
	}

}
