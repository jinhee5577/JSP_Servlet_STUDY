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
	  // 2번재 방법.
	  String id2 = (String)session.getAttribute("id");
	%>
	<h2>안녕하십니까~!. <%= id %>님 환영합니다~!. <a href="EX08LoginForm.html">로그아웃</a></h2>
</body>
</html>