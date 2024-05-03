<!-- 지시자(Directive) : jsp 설정 정보 및 문서에 포함한다, 동의 내용 작성할때,-->
<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- contentType: 응답데이터의 형식와 인코딩방식을 브라우저에게 알려주기 위해서 사용! => "text/html; charset=UTF-8" charset=UTF-8(인코딩 방식) -->
<!-- pageEncoding: jsp 페이지에 대한 인코딩 지정.=> "text/html; charset=UTF-8" charset=UTF-8(인코딩 방식) -->
<!-- 지시자의 종류: page, tagelib(JSTL), include -->

<!-- 
 서블릿파일에서 html 파일을 쓰기 귀찮기때문에 jsp파일이 -> 서블릿 파일로 변환된다. 
 컴파일 되면은 .java코드가 -> .class 코드로 컴파일 되어 html을 파일을 보여준다.
 따라서 모든 서블릿 내장코드 들이 jsp에서 동작하게된다.!.
 -->	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	주석은 HTML주석을 스크립트릿에서는 자바 주석을 사용할수 있다.
 -->

 <% 
 	//스크립트릿(Scriptlet): jsp페이지 내부에 자바코드를 삽입하는데 사용한다.
 	// .java 클래스내에 작성하는 코드 그래도 작성(세미콜론 필수)
 			
 	int num1 = 20;   // 스크립트릿에 작성한 변수/상수 선언 코드는 service메서드 아래에 작성된다.(지역번수).
 	int num2 = 30;
 	int sum = num1 + num2;
 	Random rd = new Random();
 	out.print(rd.nextInt());
  	
 %>
 		
 <h1> <%= sum %> </h1> <!-- 표현식(Expression):화면에 출력하기 위랳서 사용!(세미콜론은 작성x) -->
 
 
 <%!
    // 이자체가 service메서드에서 작성되기 때문에 메서드 안에 메서드 선언불가!.
    // 그래서 %!붙여줌. 그럼 이안에서 메서드 작성 할수 있다!. (변수도 쓸수 있음.)
    // !표를 붙이면 이안에서 선언한 메서드가 service메서드 밖으로 빼내어 선언되어 또다른 메서드 형태가 된다.
    // 이안에서 선언한 변수는 service메서드 밖으로 빼주어 변수는 필드가 된다!.
    
 	public void hi(){
	  System.out.print("hi");
   }
 %>
 
 <% hi(); %>




</body>
</html>