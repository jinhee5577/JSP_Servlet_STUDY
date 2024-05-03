package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.frontcontroller.command;

public class LogoutService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// session 값 지우고 Main.jsp로 이동
		HttpSession session = request.getSession();
		// session.invalidate();
		session.removeAttribute("loginMember");
		System.out.println("로그아웃 성공 입니다!.");
		return "Main.jsp";
	}

}
