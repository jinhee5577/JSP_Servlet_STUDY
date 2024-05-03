package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인코딩.
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nic = request.getParameter("nic");
		
		MemberDTO member = new MemberDTO(id, pw, nic);
		MemberDAO dao = new MemberDAO();
		int row = dao.join(member);
		
		if(row > 0) {
			response.sendRedirect("login.html");
			response.sendRedirect("join.html");
		}
		

	}

}
