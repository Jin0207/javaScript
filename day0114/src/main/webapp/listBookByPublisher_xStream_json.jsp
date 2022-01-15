<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String publisher = request.getParameter("publisher");
	String publisher = "쌍용미디어";
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.listBookName(publisher);
	XStream stream = new XStream();
	stream.alias("book", BookVO.class);
	String result = stream.toXML(list);

%>
<%= result %>