package Ex01GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Ex01Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");
		
		// 2. 요청 받은 데이터 꺼내기
		String id = request.getParameter("id");
	
		// 3. 출력도구 꺼내기
		PrintWriter out = response.getWriter();
		
		// 4. 화면에 출력하기
		out.print("<h1>"+ id + "님 환영합니다. </h1>");

		
		
		// 전송 방식
	   // - GET방식 : 데이터조회
		// - queryString 사용해 데이터 전송.
		// 보안에 취약하다.
		// 데이터 길이에 재한 있음
		// 공유 했을때 동일한 페이지를 볼수 있다.
		
	   // - post방식: 데이터 생성.
		// 숨겨서 보냄
		// 데이터 길이 제한 없음.
		// 공유했을때 동일한 페이지 없음.
		
		// 5. QueryString
		// url에 데이터를 포함 시키는 기술
		// ?name값=value값&name값=value값
		
		
	}

}
