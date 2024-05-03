package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontcontroller.command;

public class LogoutService implements command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// session 지우기 (로그아웃 기능)
		HttpSession session = request.getSession();
		// 2. 세션 지우기
		session.removeAttribute("info"); // session.invalidate(); //모든 섹션 삭제 한다. 비활성화.
		// 3. 메인으로 이동
		// response.sendRedirect("Main.jsp");

		return "Main.jsp";

	}

}
