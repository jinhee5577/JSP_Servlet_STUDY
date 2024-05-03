package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Operation")
public class Ex05Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");
		// 2. 요청 받은 데이터 꺼내기
		String str_number1 = request.getParameter("number1");
		String str_number2 = request.getParameter("number2");
		String op = request.getParameter("op");
		System.out.println(op);
		// 문자열(객체형태)을 기본자료형(정수, 실수)으로 변환할때는
		// Wrapper Class를 사용해서 변환 할수 있다.
		// Wrapper Class란?
		// : 기본 자료형들을 마치 레퍼런스 자료형(객체 형태)로 만들어 놓은것.

		int num1 = Integer.parseInt(str_number1);
		int num2 = Integer.parseInt(str_number2);

		// 3. 출력도구 꺼내기
		PrintWriter out = response.getWriter();
		
		// 4. 화면에 출력하기
		int res = 0;
		if (op.equals("+")) {
			System.out.println("d");
			res = num1 + num2;
			out.print("<h2>" + num1 + op + num2 + " = " + res + "</h2>");
		}
		else if (op.equals("-")) {
			res = num1 - num2;
			out.print("<h2>" + num1 + op + num2 + " = " + res + "</h2>");
		}
		else if (op.equals("/")) {
			res = num1 / num2;
			out.print("<h2>" + num1 + op + num2 + " = " + res + "</h2>");
		}
		else if (op.equals("*")) {
			res = num1 * num2;
			out.print("<h2>" + num1 + op + num2 + " = " + res + "</h2>");
		}

		
		

	}

}
