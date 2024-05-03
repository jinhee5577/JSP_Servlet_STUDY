<%@page import="java.util.ArrayList"%>
<%@page import="model_ver1.People_DTO"%>
<%@page import="java.util.List"%>
<%@page import="model_ver1.DAO_ver1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- controller와 view를 하나의 JSP에 작성함. 이게 Model-1 -->

	<% 
	   // 비즈니스 로직.
		DAO_ver1 dao = new DAO_ver1();
		ArrayList<People_DTO> list = dao.connect();
		
		// 현재 인원의 수를 알아보는 기능 넣기.
		int num = list.size();
		

	%>
	
	<table border=1> 
	 <tr>
		<th>이름</th>
		<th>전공</th>
		<th>번호</th>
	 </tr>
	 	
	 <% for(People_DTO ele : list){ %>
	  <tr>
		 <td><%= ele.getName() %></td>
		 <td><%= ele.getMajor() %></td>
		 <td><%= ele.getPhone() %></td>
	  </tr>
	  <tr>
	  	<td><%= num %></td>
	  </tr>
	 <% } %>
 	 
	</table>
	


</body>
</html>