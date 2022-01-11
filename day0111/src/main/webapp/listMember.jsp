<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String xml = "";
	xml += "<members>";
	xml += 		"<member>";
	xml += 			"<name>홍길동</name>";
	xml += 			"<age>20</age>";
	xml += 		"</member>";
	xml += 		"<member>";
	xml += 			"<name>이순신</name>";
	xml += 			"<age>35</age>";
	xml += 		"</member>";
	xml += 		"<member>";
	xml += 			"<name>유관순</name>";
	xml += 			"<age>27</age>";
	xml += 		"</member>";
	xml +=  "</members>";
%>
<%= xml %>