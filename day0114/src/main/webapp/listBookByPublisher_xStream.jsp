<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String publisher = request.getParameter("publisher");
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.listBookName(publisher);
	
	String result = "";
	result += "<bookInfo>";
	
	for(BookVO v : list){
		result += "<book>";
		result += 	"<bookName>" + v.getBookName() +"</bookName>";
		result += 	"<price>" + v.getPrice() + "</price>";
		result += "</book>";
	}
	result += "</bookInfo>";
%>
<%= result %>