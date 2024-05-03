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

public class UpdateService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 인코딩.
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 요청데이터 가져오기.
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();
		MemberDTO info = (MemberDTO) session.getAttribute("info");
		// MemberDTO객체 생성하기.
		MemberDTO updateMember = new MemberDTO(info.getEmail(), pw, tel, address);
		System.out.println(address);
		// DAO에 있는 UPDATE기능 실행.
		int count = new MemberDAO().updateMember(updateMember);

		// 콘솔창에서 성공실패 확인하기.
		String url = "";
		if (count > 0) {
			System.out.println("수정 성공");
			session.setAttribute("info", updateMember); // 새로만듬.
		//	response.sendRedirect("Main.jsp");
			url ="Main.jsp";
			
		} else {
			System.out.println("수정 실패!!!");
		//	response.sendRedirect("UpdateMember.jsp");
			url = "UpdateMember.jsp";
		}

		return null;
	}

}
