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
   String name = (String)request.getAttribute("name");
   ArrayList<String> fruit_arr = (ArrayList)request.getAttribute("fruit_arr");
%>

	<table border="1">
		<tr>
			<td>이름</td>
			<td colspan="2"><%= name %></td>
		</tr>
		<tr>
			<td>좋아하는 과일</td>
			 <td>
				<% for(String x: fruit_arr){ %>
				    <%= x %>
				<%}%>
			</td>
		</tr>
	</table>


</body>
</html>