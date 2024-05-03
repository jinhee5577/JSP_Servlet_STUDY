package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;


public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String eamil = request.getParameter("email");
		System.out.println("삭제할eamil:" + eamil);
	
		MemberDAO dao = new MemberDAO();
		int cnt = dao.deleteMember(eamil);
		
	    if(cnt> 0) {
	    	System.out.println("삭제성공");
	    } else {
	    	System.out.println("삭제실패");
	    }
	    
	    response.sendRedirect("ShowMember.jsp");
	}

}
