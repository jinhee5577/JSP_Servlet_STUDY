package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableData")
public class Ex04TableData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// service는 오버라이딩 해줄꺼야.
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");
		// 2. 요청 받은 데이터 꺼내기
		String str_number = request.getParameter("number");
		// 문자열(객체형태)을 기본자료형(정수, 실수)으로 변환할때는
		// Wrapper Class를 사용해서 변환 할수 있다.
		// Wrapper Class란?
		// : 기본 자료형들을 마치 레퍼런스 자료형(객체 형태)로 만들어 놓은것.
		
		int num = Integer.parseInt(str_number);
		
		// 3. 출력도구 꺼내기
		PrintWriter out = response.getWriter();
		
		// 4. 화면에 출력하기
		out.print("<table border=1>");
		out.print("<tr>");
		for (int i = 1; i <= num; i++) {
			out.print("<td>");
			out.print(i);
			out.print("</td>");
		}
		out.print("</tr>");
		out.print("</table>");
		
		
		
		// 1.요청받은 데이터 꺼내오기
		// 2. 문자열을 숫자로 변환.
		// int num = Integer.parseInt(data);
		// 3.select tag
		// option에 name값 달아주는게 아님.
		// select태그 자체에 name달아주기
		
		
	}

}
