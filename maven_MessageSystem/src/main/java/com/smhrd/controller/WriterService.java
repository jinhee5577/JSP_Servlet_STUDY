package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.model.BoardDAO;
import com.smhrd.model.BoardDTO;

import frontcontroller.command;

public class WriterService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 인코딩.
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// MultipartRequest: 파일 업로드를 위한 요청객체!.
		// 1. request:MultipartRequest 연결하기위한 요청(request)!
		// 2. path: 서버측에 파일을 저장할 경로 -> 상대경로 사용하는게좋음.
		// 3. maxSize : 파일의 최대 크기 지정!. ((1024*1024) = 1mb) -> (1024*1024*2) = 2mb 이다.
		// 4. encoding: 파일명의 대한 인코딩 작업!.
		// 5. DefaultFileRenamePolicy: 파일의이름이 중복되는 경우 덮어쓰기를 방지할수 있는 객체!!.

		// 2. 데이터꺼내오기.
		String path = request.getServletContext().getRealPath("file"); // (서블릿의 위치)어떤프로젝트안에 파일 경로값을 가지고옴
		int maxSize = 1024 * 1024 * 3; // 3mb
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy(); // 파일 이름 중복 되는경우 덮어쓰기 방지할수 있는객체!.

		// cos 라이브러리 필요!. Multipart에 필요!. 파일 업로드를 위한 라이브러리!
		MultipartRequest multi = null;
		try { // 1)이유설명: 원래는 try,catch 작업을 안해줬지만, implements command의 execute메서드를 우리가 만들어서 그안에서 파라미터로 request,response,를 파라미터를
			  // 받고 있는데 만일 이파라미터가 안들어올 가능성도 있어서 오류가 날경우를 처리하기 위해 try,catch로 감싸주었다.
			  // 기존 서블릿의 서비스 메서드 에서는 원래 가지고 있는 내장 객체들 request,response 이였기때문에 파라미터가 안들어올 가능성이 없었다. 
			multi = new MultipartRequest(request, path, maxSize, encoding, rename);
			// 파라미터로 request 전달되기때문에 혹시 나 request파라미터가 안들어올 경우까지 대비함.
		} catch (IOException e) {
			e.printStackTrace();
		}

		// BordWrite.jsp에서 보내준 용청값 데이터 꺼내오기.
		// multi안에 가지고있는 request에서 데이터 꺼내오겠습니다!!!!.
		String titel = multi.getParameter("titel");
		String writer = multi.getParameter("writer");

		// 사용자가 선택한 파일을 가져올때는 한글이 포함되어 있을수 있다!.
		// 해당 내용에 대하여 인코딩 작어보을 꼭 진행하기!!.
		// multi.getFilesystemName("filename"); // 다른사람도 볼수잇는 프로젝트안에 파일 경로로 바까준다?
		String filename = null;
		try { // 위에 1)이유설명: 여기도 마찬가지 이유로 try,catch로 감싸주어 작업함.
			filename = URLEncoder.encode(multi.getFilesystemName("filename"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String content = multi.getParameter("content");

		System.out.println("title: " + titel);

		// 데이터베이스 전달을 위한 작업!.

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setTitel(titel);
		dto.setWriter(writer);
		dto.setFilename(filename);
		dto.setContent(content);

		int result = dao.upload(dto);
		if (result > 0) {
			System.out.println("게시글 등록 성공!");
		} else {
			System.out.println("등록 실패!");
		}

		// response.sendRedirect("BoardMain.jsp");

		return "BoardMain.jsp";

	}

}
