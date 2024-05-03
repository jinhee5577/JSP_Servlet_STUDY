package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.MemberDAO;

public class EmailCheckService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[EmailCheckService]");
		String inputE = request.getParameter("inputE");
		
		System.out.println(inputE);
		
		boolean checkE = new MemberDAO().emailCheck(inputE);
		System.out.println(checkE);
	
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(checkE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
