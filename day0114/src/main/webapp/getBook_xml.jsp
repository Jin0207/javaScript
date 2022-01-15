<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt( request.getParameter("no") );
	//int no = 1;
	BookDAO dao = new BookDAO();
	BookVO vo = dao.listBookInfo(no);
	
	String result = "";
	result += "<book>";
	result +=	"<bookName>"+ vo.getBookName() +"</bookName>";
	result +=	"<publisher>"+ vo.getPulisher() +"</publisher>";
	result +=	"<price>"+ vo.getPrice() +"</price>";
	result += "</book>";
%>
<%= result %>
