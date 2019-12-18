package com.ssafy.rest.repo;

import com.ssafy.rest.vo.Comment;

public interface CommentDAO {
	public boolean addComment(Comment comment) throws Exception;
	public boolean updateComment(Comment comment) throws Exception;
	public boolean deleteComment(int no) throws Exception;
}
