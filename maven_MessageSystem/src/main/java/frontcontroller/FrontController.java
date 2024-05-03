package frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.LoginService;
import com.smhrd.controller.LogoutService;
import com.smhrd.controller.UpdateService;
import com.smhrd.controller.WriterService;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    // 앞으로 여기서 요청이란 요청은 여기서 다~~~ 받을꺼다!!.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("프론트 컨트롤러 들어왔다.");
		
		// 어떤 요청이 들어왓는지 확인하기.
	  String requestURI = request.getRequestURI(); // 컨텍스트 패스 프로젝트 경로?. 로컬부분을 제외한 부분이다 프로젝트내
	  StringBuffer requestURL = request.getRequestURL(); // http부터 다나오는것
	  // url=> 물리적인 주소전체 다나옴,
	  // uri => 
	  System.out.println(requestURI);  // /maven_MessageSystem_board/Main.do
	  System.out.println(requestURL);  // http://localhost:8082/maven_MessageSystem_board/Main.do
	  
	  // content roo(path) 가져오기 -> url에서 빼버릴려구
	  String context = request.getContextPath();
	  System.out.println("context: " + context);  // context: /maven_MessageSystem_board
	  
	  // 문자열 자르기
	  // subString(start) : start시작점 부터 끝까지 문자열 자르기
	  // subString(start, end) : start시작점 부터 end전까지 문자열 자르기
	  
	  String result = requestURI.substring(context.length());
	  System.out.println("요청 : " + result);
	  
	 // 진짜 들어온 result하고 비교해줄꺼임. "LoginService.do"
	  
	  command service = null;  //인터페이스 타입.
	  String moveURL = null; 
	  
	  // 여기서 바까준 서블릿들은 url맵핑을 web.xml가서 .do로 꼭 바꿔줘야한다!!!!~ 꼭!!. 근데 난 지금 귀찮아서 안바꿈 나중에 바꿀꺼다!!.
	  if(result.equals("/LoginService.do")) {//클라이언트의 입력과 입력이 어디로 가려는지 확인하기위해.
		  service = new LoginService();
	  }else if(result.equals("/LogoutService.do")) {
		  service = new LogoutService(); 
	  }else if(result.equals("/UpdateService")) {
		  service = new UpdateService(); 
	  } else if(result.equals("/WriterService")) {
		  service = new WriterService(); 
	  }
	  
	  moveURL = service.execute(request, response); // service변수에 각자 생성된 객체 안에있는 execute()메서드 실행 시켜서 리턴타입이 어디로 이동할지 "url"이 나온다.
	  if(moveURL != null) {
		  response.sendRedirect(moveURL); // 그럼 여기서 진짜 페이지 이동 시켜준다!.
	  }
	  
	  
	}

}
