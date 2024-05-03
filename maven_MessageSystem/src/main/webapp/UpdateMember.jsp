<%@page import="com.smhrd.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
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
	<%
	  MemberDTO info =(MemberDTO)session.getAttribute("info");
	%>

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
							<li><h5>회원정보수정</h5></li>
								<!-- 회원정보가 수정되도록 입력된 내용들 처리하기 -->
								<form action= "UpdateService" method= "post">
									<li>접속한 Email : <%= info.getEmail()%></li>
									<li><input type="password" placeholder="PW를 입력하세요" name="pw" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text" placeholder="전화번호를 입력하세요" value="<%= info.getTel() %>" name="tel" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text" placeholder="집주소를 입력하세요"  value="<%= info.getAddress() %>" name="address"style="width: 500px; margin: 0 auto;"></li>
									<li><input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;"></li>
								</form>
						</ul>
					</nav>			
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

