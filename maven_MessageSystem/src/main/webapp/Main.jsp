<%@page import="com.smhrd.model.MessageaDTO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.MemberDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.smhrd.model.MemberDTO"%>
<%@page import="com.smhrd.model.MessageDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Message System Example</title>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- 네이버 로그인 sdk -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
<script>
    /*  var IMP = window.IMP; 
     IMP.init("imp26780202"); 
      
    var today = new Date();   
  var hours = today.getHours(); // 시
    var minutes = today.getMinutes();  // 분
   var seconds = today.getSeconds();  // 초
   var milliseconds = today.getMilliseconds();
    var makeMerchantUid = hours +  minutes + seconds + milliseconds;
        

     function requestPay() {
         IMP.request_pay({
              pg : 'kakaopay',
             merchant_uid: "IMP"+makeMerchantUid, 
             name : '당근 10kg',
                amount : 100,
            buyer_email : 'Iamport@chai.finance',
              buyer_name : '아임포트 기술지원팀',
             buyer_tel : '010-1234-5678',
             buyer_addr : '서울특별시 강남구 삼성동',
             buyer_postcode : '123-456'
         }, function (rsp) { // callback
            if (rsp.success) {
                 console.log(rsp);
            } else {
                 console.log(rsp);
               }
           });
      } */
    </script>

<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script>
var IMP = window.IMP; 
IMP.init("imp26780202");  // kg이니시스 결제사 테스트연동 저장 시켜놓고 내 가맹점 식별코드 넣어줘야함!.

var today = new Date();   
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = hours +  minutes + seconds + milliseconds;


function requestPay() {
    IMP.request_pay({
        pg : 'html5_inicis',
        pay_method : 'card',
        merchant_uid: "IMP"+makeMerchantUid, 
        name : '당근 10kg',
        amount : 34,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : '아임포트 기술지원팀',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울특별시 강남구 삼성동',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
} 
    </script>


</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->

		<%
		MemberDTO info = (MemberDTO) session.getAttribute("info");
		%>
		<header id="header" class="alt"> <a href="Main.jsp"
			class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a> <nav>
		<!-- Q6. 로그인을 하지않은 상태에서는 로그인탭 출력 --> <!--     로그인 한 상태에서는 개인정보수정탭과 로그아웃탭 출력 -->
		<%
		if (info == null) {
		%> <a href="#menu">로그인</a> <%
 } else {
 %> <%
 if (info.getEmail().equals("admin")) {
 %> <a href="ShowMember.jsp">전체회원정보</a> <%
 }
 %> <a href="UpdateMember.jsp">개인정보 수정</a> <a href="LogoutService.do">로그아웃</a>
		<%
		}
		%> </nav> </header>

		<!-- Menu -->
		<nav id="menu">
		<ul class="links">
			<!-- Q3. 로그인 기능 만들기 -->
			<li><h5>로그인</h5></li>
			<form action="LoginService.do" method="post">
				<li><input type="text" placeholder="Email을 입력하세요" name="email"></li>
				<li><input type="password" placeholder="PW를 입력하세요" name="pw"></li>
				<li><input type="submit" value="LogIn" class="button fit"></li>
			</form>
		</ul>
		<ul class="actions vertical">
			<!-- Q1. 회원가입 기능 만들기 -->
			<li><h5>회원가입</h5></li>
			<form action="JoinService" method="POST">
				<li><input type="text" id="inputE" placeholder="Email을 입력하세요"
					name="email"></li>
				<li><input type="button" id="inputE" name="email"
					value="Email중복체크" onclick="checkE()"></li>
				<li><span id="resultcheck"></span></li>
				<li><input type="password" placeholder="PW를 입력하세요" name="pw"></li>
				<li><input type="text" placeholder="전화번호를 입력하세요" name="tel"></li>
				<li><input type="text" placeholder="집주소를 입력하세요" name="address"></li>
				<li><input type="submit" value="JoinUs" class="button fit"></li>
			</form>
		</ul>
		</nav>
		<!-- Banner -->
		<section id="banner" class="major">
		<div class="inner">
			<header class="major"> <!-- Q4. 로그인 후 로그인한 사용자의 email로 바꾸기 -->
			<!-- ex) 00님 환영합니다.  --> <%
 MemberDTO infoMember = (MemberDTO) session.getAttribute("info");
 String member = (info != null ? info.getEmail() : "비회원");
 %>

			<h1>
				<%=member%>님 로그인을 환영합니다!!~.
			</h1>
			</header>
			<div class="content">
				<!-- <p>게시판을 이용해보세요 ^^<br></p> -->
				<ul class="actions">
					<li><a href="BoardMain.jsp" class="button next scrolly">게시판
							바로가기</a></li>
				</ul>
			</div>
		</div>
		</section>

		<!-- Main -->
		<div id="main">

			<!-- One -->
			<section id="one" class="tiles"> <article> <span
				class="image"> <img src="images/pic01.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<!-- 	<a href="#" class="link">HTML</a> -->
				<!-- 아임포트 결제 연습 버튼  -->
				<button id="payment" onclick="requestPay()">아임포트 결제
					연습(구매하기)</button>
			</h3>

			<p>결제 시스템 연습</p>
			<p>홈페이지를 만드는 기초 언어</p>

			</header> </article> <article> <span class="image"> <img
				src="images/pic02.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">CSS</a>
			</h3>
			<p>HTML을 디자인해주는 언어</p>

			</header> </article> <article> <span class="image"> <img
				src="images/pic03.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">Servlet/JSP</a>
			</h3>
			<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic04.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">JavaScript</a>
			</h3>
			<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic05.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">MVC</a>
			</h3>
			<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic06.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">Web Project</a>
			</h3>
			<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
			</header> </article> </section>

			<!-- Two -->
			<section id="two">
			<div class="inner">
				<header class="major"> <!-- Q12. 로그인 이메일 출력! -->
				<h2>나에게 온 메세지 확인하기</h2>
				</header>
				<p></p>
				<%
				if (info != null) {
				%>
				<ul class="actions">
					<!-- Q14. 메시지 전체 삭제 기능 -->
					<li><a href="DelMessageAllService?email=<%=info.getEmail()%>"
						class="button next scrolly">전체삭제하기</a></li>
				</ul>
				<%
				}
				%>

				<!-- Q13. table형태로 나한테 온 메시지만 가져와서 보여주기 -->
				<%
				// 회원이 로그인을 한다면 해당 email로 받은 메시지를 가져오는 기능.
				MessageDAO dao = new MessageDAO();
				if (info != null) {
					ArrayList<MessageaDTO> m_list = dao.showMessage(info.getEmail()); // 지금 로그인한 회원의 메세지를 보여주세요.
				%>
				<table>
					<tr>
						<td>번호</td>
						<td>보낸사람</td>
						<td>내용</td>
						<td>시간</td>
						<td>삭제</td>
					</tr>

					<%
					for (MessageaDTO item : m_list) {
					%>
					<tr>
						<td><%=item.getNum()%></td>
						<td><%=item.getReciveEmail()%></td>
						<td><%=item.getMessage()%></td>
						<td><%=item.getM_date()%></td>
						<td><a href="DelMessageService?num=<%=item.getNum()%>">삭제</a></td>
					</tr>
					<%
					}
					}
					%>

				</table>



				<!-- Q15. 메시지 개별 삭제 기능 -->
			</div>
			</section>

		</div>

		<!-- Contact -->
		<section id="contact">
		<div class="inner">
			<section> <!-- Q11. 메시지 보내기 기능 -->
			<form action="MessageService" method="post">
				<div class="field half first">
					<label for="name">Name</label> <input type="text" id="name"
						name="sendName" placeholder="보내는 사람 이름" />
				</div>
				<div class="field half">
					<label for="email">Email</label> <input type="text"
						name="receveEmail" id="email" placeholder="받는 사람 이메일" />
				</div>

				<div class="field">
					<label for="message">Message</label>
					<textarea name="message" id="message" rows="6"></textarea>
				</div>
				<ul class="actions">
					<li><input type="submit" value="Send Message" class="special" /></li>
					<li><input type="reset" value="Clear" /></li>
				</ul>
			</form>
			</section>

			<section class="split"> <section>
			<div class="contact-method">
				<span class="icon alt fa-envelope"></span>
				<%
				String email = info != null ? info.getEmail() : "비회원";
				String telNum = info != null ? info.getTel() : "비회원";
				String address = info != null ? info.getAddress() : "비회원";
				%>

				<h3>Email</h3>
				<!-- Q5. 로그인 한 사용자의 이메일을 출력 -->
				<span><%=email%></span>
			</div>
			</section> <section>
			<div class="contact-method">
				<span class="icon alt fa-phone"></span>
				<h3>Phone</h3>
				<!-- Q5. 로그인 한 사용자의 전화번호를 출력 -->
				<span><%=telNum%></span>
			</div>
			</section> <section>
			<div class="contact-method">
				<span class="icon alt fa-home"></span>
				<h3>Address</h3>
				<!-- Q5. 로그인 한 사용자의 집주소를 출력 -->
				<span><%=address%></span>
			</div>
			</section> </section>
		</div>
		</section>

		<!-- Footer -->
		<footer id="footer">
		<div class="inner">
			<ul class="icons">
				<li><a href="#" class="icon alt fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon alt fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon alt fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon alt fa-github"><span
						class="label">GitHub</span></a></li>
				<li><a href="#" class="icon alt fa-linkedin"><span
						class="label">LinkedIn</span></a></li>
			</ul>
			<ul class="copyright">
				<li>&copy; Untitled</li>
				<li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>
		</footer>

	</div>

	<!---- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<!-- ajax -->

	<!-- 또다른 payment.js 파일이 필요하다.  분리는 나중에 일단은 여기 한곳에 js코드 한번에 다 넣고 연습해보자 jsp에서 js파일 만드는방법 알아보고-->
	<!-- <script src="payment.js"></script> -->



	<script type="text/javascript">
	// payment.js에 들어갈 결제 펑션
	// 구매자 정보
    // const user_email = response.req_user_email;
	   const user_email2 = "exojj159@gmail.com";
	// const username = response.req_username;
	   const username2 = "오진희";
	   
	   
	 

	   // 혹은 화살표 함수를 사용하는 방법도 있습니다.
	   
	   
	   
	// 결제창 함수 넣어주기
	// let buyButton = document.querySelector('#payment');

	// buyButton.addEventListener('click', kakaoPay(user_email2, username2));
	// buyButton.addEventListener('click', () => kakaoPay(user_email2, username2));
	 
	  
	  
	
	
	  const checkE = () =>{
		let inputE = $('#inputE').val();
		console.log(inputE);
		
		$.ajax({
			// 어디로 요청할것인지.
			url:'EmailCheckService',
			// 요청할 데이터 {key: value}
			data:{"inputE": inputE},
			// 요청방식
			type: 'get',
			// 요청에 성공했을때 무엇을 할것인지?
			success: function(data){
				if(data == 'true'){
					$('#resultcheck').text('사용할수 없는 아이디');
				} else if(data == 'false'){
					$('#resultcheck').text('사용할수 있는 아이디');
				}
			},
			// 요청에 실패했을때.
			error: function (){
				alert('통신 실패');
			}
				
		});
	  };
	  
	</script>


</body>
</html>

