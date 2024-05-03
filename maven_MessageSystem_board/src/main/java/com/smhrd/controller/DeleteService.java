package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.MemberDAO;

public class DeleteService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		
		int cnt = new MemberDAO().deleteMember(email);
		
		if(cnt > 0) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패..");
		}
		
		// response.sendRedirect("ShowMember.jsp");
		
		return "ShowMember.jsp";
	}

}
