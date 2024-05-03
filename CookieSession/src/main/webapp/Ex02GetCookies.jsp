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
  // 현재 클라이언트에 저장된 쿠기 가져오기.
  // 전부다 가져와서 Cookie[]로 쿠키배열로 변환하기.
  Cookie[] cookies = request.getCookies();

  // name, value 출력하기.
  for(Cookie c: cookies){
	  out.print(c.getName()+ ": " + c.getValue()+"<br>");
  }

%>

<a href ="Ex03RemoveCookie.jsp">쿠키삭제</a>

</body>
</html>