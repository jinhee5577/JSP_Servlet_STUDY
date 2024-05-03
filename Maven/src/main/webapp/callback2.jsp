<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<button onclick="logout()">로그아웃</button>
	<a href="extra.jsp">다른페이지</a>

	<%
     	String naverSession = "";
	%>

	<script type="text/javascript">
	
      var naver_id_login = new naver_id_login("xoUly1_dRlwHdjv5nQa7", "http://localhost:8082/Maven/callback2.jsp");
  
	    // 접근 토큰 값 출력
	    <%= naverSession %> = naver_id_login.oauthParams.access_token;
	    sessionStorage.setItem('naver_ses', naver_id_login.oauthParams.access_token);
		  // alert(naver_id_login.oauthParams.access_token);
		  // 네이버 사용자 프로필 조회
		  naver_id_login.get_naver_userprofile("naverSignInCallback()");
	  
	  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	  function naverSignInCallback() {
	   // alert(naver_id_login.getProfileData('email'));
	   //   alert(naver_id_login.getProfileData('nickname'));
	   //  alert(naver_id_login.getProfileData('age'));
	  }
  
	  
	  <% 
		  System.out.println("콜백페이지" + naverSession);
			if (!naverSession.equals("")) {
				System.out.println("콜백페이지" + naverSession);
				request.setAttribute("naever_session", naverSession);
			}
	  %>

   	
  	// 로그아웃
  	let logout = () => {
  		window.location.replace(`https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=xoUly1_dRlwHdjv5nQa7&client_secret=xoUly1_dRlwHdjv5nQa7&access_token=${naver_id_login.oauthParams.access_token}&service_provider=NAVER`);
  	}; 
  	
</script>





</body>
</html>