<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="text/plaine; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String bookName = request.getParameter("bookName");
	String publisher = request.getParameter("publisher");
	
	BookDAO dao = new BookDAO();
	int price = dao.getPrice(bookName, publisher);
%>
<%= price %>