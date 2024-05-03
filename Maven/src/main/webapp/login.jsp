<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginService" method="post">
		<input type="text" name="id" placeholder="아이디" /><br>
		<input type="text" name="pw" placeholder="비밀번호" /><br>
		<input type="submit" value="LOGIN" />

	</form>


	<button>
		<a href="./main.jsp">메인 화면으로</a>
	</button>

</body>
</html>