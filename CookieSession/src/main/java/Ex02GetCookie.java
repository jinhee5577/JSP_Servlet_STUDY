

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02GetCookie")
public class Ex02GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	//생성자.
    public Ex02GetCookie() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 클라이언트에 저장된 쿠키 가져오기.
		// 전부다 가져와서 Cookie[] 배열로 변환.
		Cookie[] cookies = request.getCookies();
		
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out =response.getWriter();
	    
	    for(Cookie c: cookies) {
	    	out.print(c.getName()+": " + c.getValue() + " = " + c.getMaxAge() + "<br>");
	    	
	    }
	    
	    
	}

}
