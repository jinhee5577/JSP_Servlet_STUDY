package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Print")
public class Ex01Print extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 기능을 담담하는 메소드.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Servlet에서 모든 코드는 service메소드 안쪽에 적는다!.
		// 0. 화면에 출력할때 한글 인코딩 잡아주는 방법.
		// * 화면에 출력하는 도구를 꺼내기 전에 인코딩을 잡아주자!.
		// * 한글 인코딩 종류 : EUS-KR / UTF-8 >> 우리는 무조건 UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		// 	request: 요청에 대한 모든 정보를 가지고 있는 객체
		// response: 응답에 대한 몯느 정보를 가지고 있는 객체
		// : 2개의 객체는 우리가 만다는게 아니라 tomcat이 알아서 수집해주는 객체.
		
		// 1). 웹피이지 화면에 출력.
		// 1-1. 화면에 출력할 수 있는 도구가 꺼내오기.
		// 화면에 출력 하겠다 == 응답을 되돌려 주겠다 ***
		// 화면 출력 할수 있는 도구 이름.
		PrintWriter out = response.getWriter(); 
	
		// 1-2. 도구 사용하기.
		out.print("<h1>jinhee world </h1>");
		
		
		for(int i= 1; i<=10; i++) {
			out.print("<h1>");
			out.print(" 오진희 남주혁");
			out.print("</h1>");
		}
	
		
		

		
		
	}

}
