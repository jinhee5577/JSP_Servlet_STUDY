package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

import frontcontroller.command;

public class LoginService implements command {
	
	// 인터페이스 메서드 구체화
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 1. 인코딩.
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. 데이터꺼내오기!.
		// 3. 로그인이 가능한지 판단! -> DAO전달 -> Login()메소드 생성!.

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		MemberDTO lo_member = new MemberDTO(email, pw, tel, address);

		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();

		dto.setEmail(email);
		dto.setPw(pw);

		MemberDTO loginMember = dao.login(lo_member);

		// 4. 로그인 결과에 따른 페이지 이동! -> Main.jsp
		if (lo_member != null) {
			// 회원의 정보를 저장하여 이동할수 있도록 수정!. -> session 영역
			System.out.println("로그인 성공!");
			// session영역 불럭오기!.
			HttpSession session = request.getSession();
			session.setAttribute("info", loginMember);
		}

		//  response.sendRedirect("Main.jsp");

		return "Main.jsp";
	}

}
