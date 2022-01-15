package com.sist.vo;

public class BookVO {
	private String bookName;
	private String pulisher;
	private int price;
	private int no;
	
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookVO(String bookName, String pulisher, int price, int no) {
		super();
		this.bookName = bookName;
		this.pulisher = pulisher;
		this.price = price;
		this.no = no;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
}