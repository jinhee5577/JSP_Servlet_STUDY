package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.frontcontroller.command;
import com.smhrd.model.Board;
import com.smhrd.model.BoardDAO;

public class BoardService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 파일 업로드를 위한 변수 설정
		// 1. request 객체
		// 2. 파일을 저장할 경로(String)
		String savePath = request.getServletContext().getRealPath("./file");
		System.out.println("savePath : " + savePath);

		// 3. 파일 최대크기(int)
		int maxSize = 1024 * 1024 * 10;

		// 4. 인코딩 방식(String)
		String encoding = "UTF-8";

		// 5. 파일이름 중복제거
		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();

		// 파일 업로드 해주는 객체 -> MultipartRequest
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, savePath, maxSize, encoding, rename);
			// 요청 데이터 받아오기
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String filename = multi.getFilesystemName("filename");
			String content = multi.getParameter("content");
			
			Board vo = new Board(title, writer, filename, content);
			System.out.println(vo.toString());
			// DB에 넣어주기
			int cnt = new BoardDAO().writeBoard(vo);
			
			if (cnt > 0) {
				System.out.println("게시글 작성 성공");
			} else {
				System.out.println("게시글 작성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// response.sendRedirect("BoardMain.jsp");

		return "BoardMain.jsp";
	}

}
