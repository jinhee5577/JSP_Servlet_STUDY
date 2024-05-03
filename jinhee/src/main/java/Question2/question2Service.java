package Question2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question2Service")
public class question2Service extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. 한글 인코딩부터 하자.
		response.setContentType("text/html;charset=UTF-8");

		// ** post방식으로 받아오 데이터를 한글 인코딩 하는 방법. 바디에 들어 있기때문에 받아올때 인코딩을 해줘야함.
		request.setCharacterEncoding("UTF-8");
		// post방식에서는 무조건 인코딩 방법 2개 다 해야함.
		
		ArrayList<String> fruit_arr2 = new ArrayList<String>();

		// 2. 요청 받은 데이터 꺼내기
		String name = request.getParameter("name");
	  	String []fruit_arr = request.getParameterValues("fruit");
		
	  	System.out.println(fruit_arr[0]);
		for(String x: fruit_arr) { 
			// 받은 배열 데이터를 ArrayList에 넣어줬음.
			fruit_arr2.add(x);
		}
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		request.setAttribute("name", name);
		request.setAttribute("fruit_arr", fruit_arr2);
		
	    rd.forward(request, response); // 데이터 들고 이동하자~!
	    
	}

}
