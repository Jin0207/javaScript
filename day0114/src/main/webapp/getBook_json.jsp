<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt( request.getParameter("bookid") );
	//int no = 1;
	BookDAO dao = new BookDAO();
	BookVO b = dao.listBookInfo(no);
	
	String result = "{\"bookname\":\" " + b.getBookName() + "\",\"publisher\":\"" +b.getPulisher()+ "\",\"price\":"+b.getPrice()+"}";
%>
<%= result %>
