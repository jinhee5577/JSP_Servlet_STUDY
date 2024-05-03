package com.smhrd.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

public class JoinService implements command{

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[JoinService]");

		// 요청데이터 받기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		Member vo = new Member(email, pw, tel, address);

		System.out.println(vo.toString());

		int cnt = new MemberDAO().joinMember(vo);

		System.out.println("cnt : " + cnt);

		if (cnt > 0) {
			// response.sendRedirect("JoinSuccess.jsp?email="+email);
			// RequestDispatcher rd = request.getRequestDispatcher("JoinSuccess.jsp");
			request.setAttribute("email", email);
			// rd.forward(request, response);
			return "JoinSuccess.jsp?email="+email;
		} else {
			return "Main.jsp";
		}
	}
	
}
