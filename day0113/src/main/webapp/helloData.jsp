<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/plaine; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	String result = "이름:" + name + "나이:" + age ;
%>
<%= result %>