<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="text/plaine; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	int no = Integer.parseInt( request.getParameter("no") );
	BookDAO dao = new BookDAO();
	BookVO vo = dao.listBookInfo(no);
	
	String bookName = vo.getBookName();
	String publisher = vo.getPulisher();
	int price = vo.getPrice();
%>
<%= bookName%>,<%=publisher%>,<%=price%>