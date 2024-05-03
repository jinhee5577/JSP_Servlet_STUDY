package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MakeTable")
public class Ex02MakeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// service에서 오버라이딩 해줄꺼야.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		
		out.print("<table border=1>");
		out.print("<tr>");
		for(int i= 1; i<=6; i++) {
			out.print("<td>");
			out.print(i);
			out.print("</td>");
		}
		out.print("</tr>");
		out.print("</table>");
	
		
	}

}
