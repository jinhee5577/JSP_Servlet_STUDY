package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.MessageDAO;

public class DelMessageService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("num"));
		
		int cnt = new MessageDAO().deleteMessage(num);
		
		if(cnt > 0) {
			System.out.println("메세지 삭제 성공");
		}else {
			System.out.println("메세지 삭제 실패");
		}
		
		// response.sendRedirect("Main.jsp");
		
		return "Main.jsp";
	}

}
