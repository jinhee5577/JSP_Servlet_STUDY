<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	  String id = request.getParameter("id"); // JSP의 Scope(영역)의 문제. 벗어남()
	  String id2 = (String)(request.getAttribute("id")); // JSP의 Scope(영역)의 문제. 벗어남()  요것도 안됨!!.
	%>

	<h2><%= id %>님 환영합니다.</h2>
	<h2><%= id2 %>님 환영합니다.</h2>

</body>
</html>