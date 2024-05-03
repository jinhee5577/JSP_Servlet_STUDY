package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;


public class DelMessageService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int cnt = new MessageDAO().deleteMessage(num);
		
		if(cnt > 0) {
			System.out.println("딜리트 성공");
		}else {
			System.out.println("딜리트 실패!");
		}
		
		response.sendRedirect("Main.jsp");
		
	}

}
