
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		// 이게 현재 controller역할.
		// 일부러 무거운 로직이 있을겨우 서블릿에 분리해서 controller역할을 하게한다.
		// 이서블릿 페이지에서의 로직을 jsp에서도 쓸수 있지만 만약 더무거운 로직이 존재할경우
		// 서블릿으로 빼서 java코드 (무거운)로직을 작성 하게 한다!.
		// jsp에서는 간단하게 html로 뷰단 에서 보여줄때 작성한다!.
		
		// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");
		// 2. 요청 받은 데이터 꺼내기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("test") && pw.equals("12345")) {
			// 1.세션 id값 넣어주기. 먼저 세션 객체만들기.
			// 2. 메인페이지 이동하기.
			HttpSession session = request.getSession();
			session.setAttribute("id", id); //문자열 넣기.
			RequestDispatcher rd = request.getRequestDispatcher("Ex08Main.jsp");
			rd.forward(request, response);  // 이때 어디페이지로 가는데 응답 객체를 통째로 들고간다. 아하!!~~
			
			// sendRedirect: 요청과 응답이 2번함, DB의 변화가 있을때, 기본이 get방식.
			// forward: DB의 변화가 없을때 사용해야 안전하다., f5를 계속 누르면 인출이 계속 일어남.
			// method를 post로 변경.
			
			// 2-1. sendRedirect
			// 쌤의 두번째 방법.
		//	response.sendRedirect("Ex08Main.jsp");
		}else {
			// 아이디, 비번 틀릴경우 다시 로그인 시키도록 로그인 페이지 이동시킴.
			response.sendRedirect("EX08LoginForm.html");
		}
		
		

	}

}
