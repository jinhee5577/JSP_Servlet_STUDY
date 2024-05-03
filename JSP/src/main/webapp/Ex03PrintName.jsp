<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 
 서블릿파일에서 html 파일을 쓰기 귀찮기때문에 jsp파일이 -> 서블릿 파일로 변환된다. 
 컴파일 되면은 .java코드가 -> .class 코드로 컴파일 되어 html을 파일을 보여준다.
 따라서 모든 서블릿 내장코드 들이 jsp에서 동작하게된다.!.
 -->	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");
		// 2. 요청 받은 데이터 꺼내기
		// request 내장객체 
		// POST방식으로 요청할때, 인코딩 방식이 필요하다.
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		// 문자열(객체형태)을 기본자료형(정수, 실수)으로 변환할때는
		// Wrapper Class를 사용해서 변환 할수 있다.
		// Wrapper Class란?
		// : 기본 자료형들을 마치 레퍼런스 자료형(객체 형태)로 만들어 놓은것.
	

	
		// 3. 출력도구 꺼내기
	%>

	입력한 이름: <%= name %>
	입력한 이름: <% out.print(name); %>
	
</body>
</html>