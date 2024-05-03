<%@page import="model_ver1.People_DTO"%>
<%@page import="java.util.ArrayList"%>
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
		// 서버에서 세션 정보 가져오는거임. jsp파일에서 실행하고 있으니.
		response.setContentType("text/html; charset=UTF-8");
		int num = (int) session.getAttribute("num"); // Integer => int의 class형태.
		ArrayList<People_DTO> member_list = (ArrayList<People_DTO>) session.getAttribute("list");
	%>
	<h2><%= num %> 진희</h2>
	
	
	<table border=1> 
	 <tr>
		<th>이름</th>
		<th>전공</th>
		<th>번호</th>
	 </tr>
	 	
	 <% for(People_DTO ele : member_list){ %>
	  <tr>
		 <td><%= ele.getName() %></td>
		 <td><%= ele.getMajor() %></td>
		 <td><%= ele.getPhone() %></td>
	  </tr>
	  
	 <% } %>
 	 
	</table>
	
	
</body>
</html>