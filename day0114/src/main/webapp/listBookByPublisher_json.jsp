<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String publisher = request.getParameter("publisher");
	//String publisher = "쌍용미디어";
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.listBookName(publisher);
	
	String result = "[";
	
	for(int i = 0; i<list.size(); i++){
		BookVO b = list.get(i);
		result += "{\"bookname\":\""+ b.getBookName() +"\", \"price\": "+ b.getPrice()+"}";
		
		if(i != list.size()-1){
			result += ",";	
		}
	}
	
	result += "]";
%>
<%= result %>