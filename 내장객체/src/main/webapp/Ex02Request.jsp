<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>

<%
	// 1. 한글 인코딩부터 하자.
	response.setContentType("text/html;charset=UTF-8");
	// 응답해줄걸 html에, 문서에 보여줄때 또한번 인코딩 해준다.
	
	// ** post방식으로 받아오 데이터를 한글 인코딩 하는 방법. 바디에 들어 있기때문에 받아올때 인코딩을 해줘야함.
	request.setCharacterEncoding("UTF-8");
	// post방식에서는 무조건 인코딩 방법 2개 다 해야함.
	
	// 2. 요청 받은 데이터 꺼내기
	String name = request.getParameter("name");
	int java = Integer.parseInt(request.getParameter("java"));
	int web = Integer.parseInt(request.getParameter("web"));
	int iot = Integer.parseInt(request.getParameter("iot"));
	int android = Integer.parseInt(request.getParameter("android"));
	
	double avg = (java + web + iot + android) / 4.0;
	
	String grade;
	if(avg >= 95){
		grade= "A+";
	} else if(avg >= 90){
		grade= "A";
	}else if(avg >= 85){
		grade= "B+";
	}else if(avg >= 80){
		grade= "B";
	} else {
		grade= "F";
	}
	
	
	// out.print("<h2> 이름: " + name + "</h2>");
	// out.print("<h2> java 점수: " + java + "</h2>");
	// out.print("<h2> web 점수: " + web + "</h2>");
	// out.print("<h2> iot 점수: " + iot + "</h2>");
	// out.print("<h2> android 점수: " + android + "</h2>");
	// out.print("<h2> 평균: " + avg + "</h2>");
	

%>

 <fieldset width ="500px">
 	<legend>학점확인 프로그램</legend>
 	<table align="cneter">
 		<tr>
 			<td>이름: </td>
 			<td><%= name %></td>
 		</tr>
 		<tr>
 			<td>java 점수:</td>
 			<td><%= java %></td>
 		</tr>
 		<tr>
 			<td>web 점수: </td>
 			<td><%= web %></td>
 		</tr>
 		<tr>
 			<td>iot 점수: </td>
 			<td><%= iot %></td>
 		</tr>
 		<tr>
 			<td>android 점수:</td>
 			<td><%= android %></td>
 		</tr>
 		<tr>
 			<td>평균: </td>
 			<td><%= avg %></td>
 		</tr>
 		</tr>
 		<tr>
 			<td>학점: </td>
 			<td><%= grade %></td>
 		</tr>
 	
 	</table>
 </fieldset>





</body>
</html>