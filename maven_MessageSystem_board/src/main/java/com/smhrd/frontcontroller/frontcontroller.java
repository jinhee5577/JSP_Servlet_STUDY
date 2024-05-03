package com.smhrd.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.controller.BoardService;
import com.smhrd.controller.DelMessageAllService;
import com.smhrd.controller.DelMessageService;
import com.smhrd.controller.DeleteService;
import com.smhrd.controller.EmailCheckService;
import com.smhrd.controller.JoinService;
import com.smhrd.controller.LoginService;
import com.smhrd.controller.LogoutService;
import com.smhrd.controller.MessageService;
import com.smhrd.controller.UpdateService;
import com.smhrd.model.Board;
import com.smhrd.model.BoardDAO;
import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.Message;
import com.smhrd.model.MessageDAO;

@WebServlet("*.do")
public class frontcontroller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[FrontContoller]");

		// 어떤 요청이 들어왔는지 확인
		String requestURI = request.getRequestURI();
		System.out.println("요청이 들어온 주소 : " + requestURI);

		// ContextPath 확인
		String contextPath = request.getContextPath();
		System.out.println("ContextPath : " + contextPath);

		// 문자열 자르기
		// subString(start) : start 위치부터 끝까지 문자열 자르기
		// subString(start, end) : start 위치부터 end 전까지 문자열 자르기
		String result = requestURI.substring(contextPath.length());
		System.out.println("요청 서블릿 : " + result);

		request.setCharacterEncoding("UTF-8");
		String moveURL = null;
		command service = null;  // 인터페이스로 업캐스팅으로 받을거임.
		
		if (result.equals("/LoginService.do")) { // 로그인 기능
			service = new LoginService();
		} else if (result.equals("/JoinService.do")) { // 회원가입 기능
			service = new JoinService();
		}else if(result.equals("/LogoutService.do")) {
			service = new LogoutService();
		}else if(result.equals("/UpdateService.do")) {
			service = new UpdateService();
		}else if(result.equals("/DeleteService.do")) {
			service = new DeleteService();
		}else if(result.equals("/DelMessageAllService.do")) {
			service = new DelMessageAllService();
		}else if(result.equals("/DelMessageService.do")) {
			service = new DelMessageService();
		}else if(result.equals("/MessageService.do")) {
			service = new MessageService();
		}else if(result.equals("/EmailCheckService.do")) {
			service = new EmailCheckService();
		}else if(result.equals("/BoardService.do")) {
			service = new BoardService();
		}
		
		
		moveURL = service.execute(request, response);
		if(moveURL != null) {
			response.sendRedirect(moveURL);
		}
		
		
	}

}
