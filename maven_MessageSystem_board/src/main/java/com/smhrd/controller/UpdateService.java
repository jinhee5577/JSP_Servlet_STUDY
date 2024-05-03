package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

public class UpdateService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 2. 요청데이터 가져오기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		// 3. Member객체 생성
		Member updateMember = new Member(email, pw, tel, address);

		// 4. DAO에 있는 updateMember() 호출 -> 정수데이터 반환
		int cnt = new MemberDAO().updateMember(updateMember);

		// 5. 콘솔창에 수정 성공
		if (cnt > 0) {
			System.out.println("수정 성공!");
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", updateMember);
			// response.sendRedirect("Main.jsp");
			return "Main.jsp";
	
			} else {System.out.println("수정 실패..");
			// response.sendRedirect("UpdateMember.jsp");
			return "UpdateMember.jsp";
		}

	}

}
