package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;


public class LoginService extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 인코딩.
      request.setCharacterEncoding("UTF-8");
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      
      MemberDTO member = new MemberDTO(id, pw);
      
      MemberDAO dao = new MemberDAO();
      MemberDTO loginMember = dao.login(member);
      
      if(loginMember != null) {
         HttpSession session = request.getSession();
         session.setAttribute("member", loginMember); // 세션에 객체 자체를 키,밸류로 셋팅해줌
         response.sendRedirect("main.jsp");
      } else {
         System.out.println("id , pw 정확히 입력해주세요.");
         response.sendRedirect("login.html");
      }
   }

}