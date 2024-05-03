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
		ArrayList<People_DTO> list = (ArrayList<People_DTO>)request.getAttribute("list"); // 들어올때 오브젝트 타입으로 들어있음. 따라서 (ArrayList<People_DTO>)로 형변환 해준다.
		int num = (int)request.getAttribute("num");
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