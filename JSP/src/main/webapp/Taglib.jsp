<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  <!-- 이거 꼭 작성해야함. -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="num" value="2" />
	<c:if test="${num % 2 == 0}">
	짝수
	</c:if>

	 <c:forEach var="변수명" items="${리스트}">
	
	</c:forEach>

	<c:out value="${num}" ></c:out>


</body>
</html>