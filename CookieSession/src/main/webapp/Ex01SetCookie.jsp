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
	// 쿠키 객체 생성하기. Cookie(name(String),value(String))
	Cookie cookie = new Cookie("test", "테스트");
	// 쿠키는 키: 밸류 한쌍만 실어 보낼수 있다.

	// 만료시간 설정.(초)
	cookie.setMaxAge(60*60); // 1시간
	// 서버에서 생성된 쿠키를 클라이언트로 보내기.
	response.addCookie(cookie);  // 클라이언트로 방금 만든 쿠키를 보낸다. 
	
	//만료 기간을 지정하면 쿠키가 생성될때 session cookie로 생성됨.(session활용시 사용됨. --> 브라우저를 끄면 전부 사라짐.)
	response.addCookie(new Cookie("id", "smart"));

%>
<!--  // 시으니 왔다감>.< -->

  <a href="Ex02GetCookies.jsp">쿠키확인</a>
  <a href="Ex02GetCookie">쿠키확인(servlet)</a>	

</body>
</html>