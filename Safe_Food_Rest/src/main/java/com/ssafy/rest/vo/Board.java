package com.ssafy.rest.vo;

public class Board {
	private int no;
	private String id;
	private String contents;
	private String date;
	
	public Board() {
		super();
	}

	public Board(int no, String id, String contents, String date) {
		super();
		this.no = no;
		this.id = id;
		this.contents = contents;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", id=" + id + ", contents=" + contents + ", date=" + date + "]";
	}
	
}
