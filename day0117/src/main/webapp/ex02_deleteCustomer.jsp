<%@page import="com.sist.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int custid = Integer.parseInt( request.getParameter("custid") );
	CustomerDAO dao = new CustomerDAO();
	int re = dao.delete(custid);
%>
{"re":<%=re%>}