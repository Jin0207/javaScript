package com.sist.vo;

public class BookVO {
	private String bookName;
	private String pulisher;
	
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookVO(String bookName, String pulisher) {
		super();
		this.bookName = bookName;
		this.pulisher = pulisher;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPulisher() {
		return pulisher;
	}

	public void setPulisher(String pulisher) {
		this.pulisher = pulisher;
	}
	
	
	
}
