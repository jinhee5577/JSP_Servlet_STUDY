package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

public class LoginService implements command{

	public String execute (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[LoginService]");
		// 1. email, pw 가져오기(post 인코딩)
		// 2. Member 객체 생성
		// 3. DAO loginMember() 메소드 호출
		// 4. DB에 있는 값 가져와서 콘솔창에 tel값만 출력하기

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		Member vo = new Member(email, pw);

		Member loginMember = new MemberDAO().loginMember(vo);

		if (loginMember != null) {
			// 로그인 성공
			System.out.println("로그인 성공!");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
		}

		return "Main.jsp";
	}
	
}
