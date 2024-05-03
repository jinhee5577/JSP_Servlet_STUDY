package Question3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");

		// ** post방식으로 받아오 데이터를 한글 인코딩 하는 방법. 바디에 들어 있기때문에 받아올때 인코딩을 해줘야함.
		request.setCharacterEncoding("UTF-8");
		// post방식에서는 무조건 인코딩 방법 2개 다 해야함.

		// 2. 요청 받은 데이터 꺼내기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String user_id = "smart";
		String user_pw = "1234";
		
		HttpSession session = request.getSession();
		
		if(id.equals(user_id) && pw.equals(user_pw)) {			
			session.setAttribute("id", user_id);
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("loginForm.html");
		}

	}

}
