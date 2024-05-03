<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>안녕 하세요.</h1>
   <button>
      <a href="./login.html">로그인</a>
   </button>
   <button>
      <a href="./join.html">회원가입</a>
   </button>
   <!--  <button onclick="logout()">로그아웃</button>  -->
   <button onclick="logout()">로그아웃버튼</button>

   <%
      boolean cnt = false;  // 현재 로그인한 유저인지 체크용 변수.
      try {
         MemberDTO Loginmember = (MemberDTO)session.getAttribute("member");
   		 System.out.println(Loginmember);
         if (Loginmember != null) {
            cnt = true;
            out.print(Loginmember.getId());
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   %>

   <script>
   
    const logout = ()=> {
       let check = <%=cnt%>  // 불리언값 들어감.
       if(check){ // 유저가 로그인 한 상태라면
           check = false;
           alert("로그아웃 되셨습니다!.");
           if(!check) {
             <% session.removeAttribute("member");
                cnt = false; // 위에 자바변수 다시 false로 변경.                    
               // response.sendRedirect("login.html");  // 다시 로그인하든가 페이지 이동. 왜 이것만 들어가면 안되는거냐?!!
            %>
               // 이렇게 하면 일단 로그아웃 기능은 됨.
              window.location.replace('login.html'); // 왜 이문장이 있으면 로그아웃 안하고 로그인페이지갓다가 - 메인페이지가면 기존 유저 id가 안보이지.??
           } 
       }
       else{ // 로그인 안했다면 로그인부터좀 해라.
          alert("로그인 해주세요!");
       }
     };
   
   
   
   </script>
</body>
</html>