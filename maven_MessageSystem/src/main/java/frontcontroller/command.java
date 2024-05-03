package frontcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface command {
	
	// 인터페이스 : 틀
	// 추상메서드: 값은 없지만 메서드의 기본 값을 설정해주는 역할.
	// request와 response를 따로 구현해주기위해 인터페이스를 만듬!!!!.
	
	public String execute(HttpServletRequest request, HttpServletResponse response); // 추상 메서드
	
	

}
