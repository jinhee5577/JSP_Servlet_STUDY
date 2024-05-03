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
    	String naver_ses = (String)request.getAttribute("naever_session");
	    System.out.println("또다른페이지"+naver_ses);
	%>

	<p>또다른 페이지 입니다.</p>


	<script type="text/javascript">
	  let check = sessionStorage.getItem('naver_ses');
	  console.log(check);

	
	</script>


</body>
</html>