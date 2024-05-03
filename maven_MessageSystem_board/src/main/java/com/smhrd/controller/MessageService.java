package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontcontroller.command;
import com.smhrd.model.Message;
import com.smhrd.model.MessageDAO;

public class MessageService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[MessageService]");
		
		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");
		
		System.out.println("sender : "+sendName);
		System.out.println("recipient : "+receiveEmail);
		System.out.println("message : "+message);
		
		Message vo = new Message(0, sendName, receiveEmail, message, null);
		int row = new MessageDAO().insertMessage(vo);
		
		if(row > 0) {
			System.out.println("메시지 전송 성공");
		}else {
			System.out.println("메시지 전송 실패");
		}
		
		// response.sendRedirect("./Main.jsp");
		
		return "./Main.jsp";
	}

}
