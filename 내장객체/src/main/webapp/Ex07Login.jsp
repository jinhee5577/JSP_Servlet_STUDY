<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//** post방식으로 받아오 데이터를 한글 인코딩 하는 방법. 바디에 들어 있기때문에 받아올때 인코딩을 해줘야함.
		request.setCharacterEncoding("UTF-8");
		// post방식에서는 무조건 인코딩 방법 2개 다 해야함.
	
		// 2. 요청 받은 데이터 꺼내기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("smart") && pw.equals("123")){
			request.setAttribute("id", id);  // request영역에 데이터를 저장하는 방법.
			RequestDispatcher rd = request.getRequestDispatcher("Ex07LoginSuccess.jsp");
			// RequestDispatcher:  클라이언트로부터 최초에 들어온 요청을 원하는 자원으로 넘기는 등의 메서드를 가짐.
			//	response.sendRedirect("Ex07LoginSuccess.jsp"); // 요청을 2번 DB에 변동사항이 생겼을때 사용함.
			rd.forward(request, response);  // 이때 어디페이지로 가는데 응답 객체를 통째로 들고간다. 아하!!~~
			// forward: 다음페이지로 request,response를 넘기는 역할 을 한다.
			// forward :는 요청과 응답이 1번 DB변동 사항이 없을때 사용함.
		
			
		} else {
			response.sendRedirect("Ex07LoginFail.jsp");
		}
		
		
		
		
	%>


</body>
</html>