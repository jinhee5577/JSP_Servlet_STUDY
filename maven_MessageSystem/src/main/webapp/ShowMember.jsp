<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.smhrd.model.MemberDAO" %>
<%@page import="com.smhrd.model.MemberDTO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Message System Example</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
		<!-- Wrapper -->
		<%
		   MemberDAO dao =	new MemberDAO();
		   List<MemberDTO> members =  dao.allMember();	
		
		%>
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<% for(MemberDTO item : members){ %>
								<tr>
									<td><%= item.getEmail()%></td>
									<td><%= item.getTel()%></td>
									<td><%= item.getAddress()%></td>
									<td><a href="DeleteService?email=<%=item.getEmail()%>">삭제</a></td>
								</tr>
							<% } %>
					
						</table>
					</nav>		
					<a href="Main.jsp" class="button next scrolly">되돌아가기</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

