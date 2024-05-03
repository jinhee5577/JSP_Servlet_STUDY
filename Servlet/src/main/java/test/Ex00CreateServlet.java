package test;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 1). @ >> annotation: url mapping값을 잡아주는 구간.
// @WebServlet("경로"): 어노테이션
// --> url 경로가 실행되면(요청이 들어오면) 해당하는 파일을 실행해서 결과를 돌려준다.
// 경로를 간소화 시켜서 표현하는것이 가능하다.
// 파일명을 그대로 드러내지 않기때문에 보안에 유리하다.
  // url맵핑을 해주는 기능이 있음.
@WebServlet("/Create") 
public class Ex00CreateServlet extends HttpServlet {// 추상클래스에 정의 되어 있는것을 상속받아 정의 하겠다.
	// 2).시리얼 번호: 
	// .java -> .class 파일로 바뀜(컴파일하면) -> .html 형식으로 server 배포가 된다.
	// 해당 파일이 서블릿 파일임을 알려주는 코드.
	private static final long serialVersionUID = 1L;
       
	
    // 3). 생성자.
    public Ex00CreateServlet() {
        super();
        System.out.println("생성자 호출");
    }


    // 4). 서블릿 초기화 시켜주는 메소드(initialize)
	public void init(ServletConfig config) throws ServletException {
		System.out.println("초기화 메소드 실행.");
	}

	
	// 5). Servlte을 소멸시키고 싶을때 사용하는 메소드.
	public void destroy() {
		System.out.println("destroy 메소드 호출");
		// 서버를 종료,닫아줄때까지 실행됨.
	}
	
	// 이러한 관리를 서블릿 컨테이너가 자동으로 관리 해준다.
	// 여기까지는 손댈 필요가 없음 기존기능 그대로 사용하면 된다. (거의 한번만 써서 오버라이딩 할필요가 없음.)
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 6). ★★★★java에서 main메소드 역할,과 같은 기능. 요청이 들어오면 실행되는 메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 메소드 실행");
		// 이메소드만 가지고 오버라이딩 해줄꺼다.
	}

	// 7). doGet,doPost  --> server로 요청이 들어오는 방식이 다양한다.
	// get방식으로 요청이 들어올때 실행하고 싶은 메소드: doGet
	// post 방식으로 요청이 들어올때 실행하고 싶은 메소드: doPost
	// 요청 방식을 구분하지 않고 어떤 요청이 들어오더라도 실행되는 메소드: service
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// post요청.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
