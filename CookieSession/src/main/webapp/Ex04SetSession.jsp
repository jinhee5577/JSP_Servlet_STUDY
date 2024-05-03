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
	// 클라이언트로 세션 보냄.
  	session.setAttribute("id","오진희"); //문자열 넣기
    session.setAttribute("age", 16); // 숫자 넣기
    
    ArrayList<String> array = new ArrayList<>();
    array.add("피자");
    array.add("카레라이스");
    array.add("우동");
    session.setAttribute("food", array); // ArrayList 넣기.
    // 세션은 무엇이든 담을수 있다.

%>

<a href="Ex05GetSession.jsp">세션확인</a>
<a href="Ex05GetSession">세션확인)(servlet)</a>


</body>
</html>