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
	// 삭제 메서드는 따로 없다.
	// 1.삭제하고 싶은 쿠키의name과 같은 name을 가진 쿠키생성.
	// 삭제 하고 싶은 쿠키를 같은 이름으로 객체를 새로 생성해서 만료시간을 0초로 하고
	// 응답으로 클라이언트 브라우저로 보내버리면 그게 쿠키 삭제이다.
	Cookie cookie = new Cookie("test", "");
	
	// 2.만료기간 0초
	cookie.setMaxAge(0);
	// 3. 서버에서 생성된 쿠키를 클라이언트로 전송.
	response.addCookie(cookie);
	// 쿠키는 보안이 별로안중요할대 사용함.
	// 세션은 보안이 중요할때 사용함. (서버에서 생성및 저장.)
%>

<a href="Ex02GetCookies.jsp">쿠키확인</a>


</body>
</html>