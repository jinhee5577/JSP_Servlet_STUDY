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
     	pageContext.setAttribute("name", "남주혁");
	    // 변수처럼 선언한곳 에서만 사용가능함.
	    // 키,벨류를 쓰는곳에 내장객체를 활용해서 그때 사용함.
	%>

	<%=pageContext.getAttribute("name")%>
</body>
</html>