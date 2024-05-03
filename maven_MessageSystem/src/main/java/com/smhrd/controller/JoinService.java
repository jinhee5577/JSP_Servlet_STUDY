package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입을 위한 서비스!.
		// 1. 요청값 인코딩하여 받아오기!.
		request.setCharacterEncoding("UTF-8");
		// EUC-kr -> 뛣 이러문자를 그대로 인식함.
		// UTF-8 -> ㅂ, ㅅ,ㅔ, ㄹ, ㅎ ??? 머라공??

		// 2. 요청값에서 필요한 데이터 꺼내오기!.
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String pw = request.getParameter("pw");

		// 3.처리해야 하는 로직 구형 -> 회원가입!.
		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();
		int result = dao.join(dto);

		// 4. 결과 처리!!.
		if (result > 0) {
			// 회원가입 성공시!
			// 회원의 이메일 값을 JoinSuccess.jsp페이지로 공유하기!.
			// -> request영역 확용하기!.
			// -> 페이지 이동방식 -> forward 방식
	    // response.sendRedirect("JoinSuccess.jsp");
			
			// forward방식으로 데이터 실어서 넘겨줄거야.
			request.setAttribute("email", email);
			//request.setAttribute은 request객체에 "email"이름으로된 키, 밸류 값을 셋팅해서 request, response 매개변수 둘을 넘겨줄거다!!.   
			RequestDispatcher rd = request.getRequestDispatcher("JoinSuccess.jsp");
			// request.getRequestDispatcher에서 JoinSuccess.jsp로 간다고 요청을 만들고,
			// 실제 데이터를 들고 페이지 이동을 해주는것은 rd.forward()이다.
			rd.forward(request, response);  // 이때 어디페이지로 가는데 응답 객체를 통째로 들고간다. 아하!!~~
			// 이걸 frontController로 변경해서 처리해줄려면 forward요거 처리는 
			// request.setAttribute(key, value); 로 셋팅해서 보낸준다. 그런데 위에 있어서 안해줘도 될듯하다!.
			// 그리고 이동한 페이지에서 request.getAttribute(key);로 데이터 받아서 처리해주면 될듯하다. 쌤이 또다른 방법이 있다고 한거 같다!.
			
		} else {
			response.sendRedirect("Main.jsp");
		}


	}

}
