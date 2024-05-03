<%@page import="java.util.ArrayList"%>
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
	// session.getAttribute("id")는 오브젝트로 뱉은 따라서 String으로 형변환 해줌.(각각 해당 타입으로)
	String id = (String)session.getAttribute("id");
    // 서버에서 세션 정보 가져오는거임. jsp파일에서 실행하고 있으니.
	Integer age = (Integer)session.getAttribute("age");  // Integer => int의 class형태.
	ArrayList<String> food_arr = (ArrayList<String>)session.getAttribute("food");
	
			
			
%>

<h2>id : <%= id %></h2>
<h2>age : <%= age %></h2>
<h2>food : <%= food_arr %></h2>
<a href="Ex06RemoveSession.jsp">세션 삭제</a>
<a href="Ex07INvalidate.jsp">세션모두 삭제</a>


</body>
</html>