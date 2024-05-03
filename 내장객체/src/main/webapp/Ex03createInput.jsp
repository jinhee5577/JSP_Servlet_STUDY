<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">

<%
	
	// ** post방식으로 받아오 데이터를 한글 인코딩 하는 방법. 바디에 들어 있기때문에 받아올때 인코딩을 해줘야함.
	request.setCharacterEncoding("UTF-8");
	// post방식에서는 무조건 인코딩 방법 2개 다 해야함.
	
	// 2. 요청 받은 데이터 꺼내기
	int number =Integer.parseInt(request.getParameter("num"));
	
	
%>

<h2>랜덤 담청 게임</h2>

<form action="Ex03RandomOutput.jsp" method="post">
	<fieldset>
		<legend>랜덤 뽁기</legend>
		<table align="center">
		  <tr>
		  	<td>주제: </td>
		  	<td><input type="text" name="topic" /></td>
		  </tr>
		<% for(int i =1; i<= number; i++){ %>
		  <tr>
			<td>아이템: </td>
			<td><input type="text" name="item" /></td>
		  </tr>
		<%}%>
		  <tr>
			<td colspan="2"><input type="submit" name="랜덤뽑기" /></td>
		  </tr>
		</table>
	</fieldset>

</form>


</body>
</html>