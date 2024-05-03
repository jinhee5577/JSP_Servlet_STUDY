package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.MessageDAO;

public class DelMessageAllService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		
		int cnt = new MessageDAO().deleteMessageAll(email);
		
		if(cnt > 0) {
			System.out.println("전체 메세지 삭제 성공");
		}else {
			System.out.println("전체 메세지 삭제 실패");
		}
		
		// response.sendRedirect("Main.jsp");
		
		return "Main.jsp";
	}

}
