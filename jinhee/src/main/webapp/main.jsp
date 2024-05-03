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
	String id = (String) session.getAttribute("id");
	%>

	<form action="Logout" >
		<table border="1">
			<tr>
				<td><%= id %>님 환영합니다!.</td>
			</tr>
			<tr>
				<td><input type="submit" value="로그아웃" /></td>
			</tr>
		</table>
	</form>

</body>
</html>