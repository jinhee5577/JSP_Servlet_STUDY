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
	int sum = 0;
	for (int n = 1; n <= 100; n++) {
		sum += n;
	}
	%>

	<table border=1>
		<tr>
			<% for(int i=1; i<=10; i++){%>  <!-- 스크립트렛 -->
				<td>  <%= i %>  </td>
	     	<%} %>
		</tr>
	</table>

	<table border=1>
		<tr>
			<% for(int i=1; i<=10; i++){ // 자바코드 열림.
				// JSP에서는 out객체 생성없이 바로 사용할수 있다.
				// print()는 문자열을 출력 하는 메서드.
				out.print("<td>" + i + "</td>");
	     	}
	     	%>
		</tr>
	</table>



	<h1><%= sum %></h1>
</body>
</html>