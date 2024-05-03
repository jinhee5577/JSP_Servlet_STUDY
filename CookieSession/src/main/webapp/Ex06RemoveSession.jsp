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
	// 서버에 세션이 저장되어 있으니 서버에서 세션을 지운다.
	session.removeAttribute("age");
%>

<a href="Ex05GetSession.jsp">세션확인</a>
</body>
</html>