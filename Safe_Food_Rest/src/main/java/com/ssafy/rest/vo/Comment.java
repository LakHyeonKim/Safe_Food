package com.ssafy.rest.vo;

public class Comment {
	private int no;
	private String content;
	private int boardNo;
	
	public Comment() {
		super();
	}

	public Comment(int no, String content, int boardNo) {
		super();
		this.no = no;
		this.content = content;
		this.boardNo = boardNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Comment [no=" + no + ", content=" + content + ", boardNo=" + boardNo + "]";
	}
	
}
