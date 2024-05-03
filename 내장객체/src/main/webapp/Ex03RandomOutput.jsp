<%@page import="java.util.Random"%>
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
	// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");
		// 응답해줄걸 html에, 문서에 보여줄때 또한번 인코딩 해준다.
		
		// ** post방식으로 받아오 데이터를 한글 인코딩 하는 방법. 바디에 들어 있기때문에 받아올때 인코딩을 해줘야함.
		request.setCharacterEncoding("UTF-8");
		// post방식에서는 무조건 인코딩 방법 2개 다 해야함.
		String topic = request.getParameter("topic");
	    String[] ran_items = request.getParameterValues("item");
	    Random rd = new Random();
	    String ran_item = ran_items[rd.nextInt(ran_items.length)];
	
	%>
	
	<h2>랜덤 당첨게임</h2>
	<fieldset width="300px">
		<legend>랜덤 뽑기 결과</legend>
		<table align="center">
		  <tr>
		  	<td>주제: </td>
		  	<td><%= topic %></td>
		  </tr>
		  <tr>
		  	<td><%= ran_item %></td>
		  </tr>
		</table>
	</fieldset>



</body>
</html>