package com.ssafy.rest.service;

import com.ssafy.rest.vo.Comment;

public interface CommentService {
	public boolean addComment(Comment comment) throws Exception;
	public boolean updateComment(Comment comment) throws Exception;
	public boolean deleteComment(int no) throws Exception;
}
