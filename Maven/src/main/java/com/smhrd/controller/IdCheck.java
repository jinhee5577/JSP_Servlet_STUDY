package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.smhrd.model.Member2;


public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("잘도착");
		
		// 사용자가 입력한 id값 꺼내기.
	 	 String id = request.getParameter("inputId");
//		 JsonObject jsonObject = new JsonObject();
//		 String id = String.valueOf(jsonObject.get("inputId"));
		 
	 	 System.out.println(id);
		// id에 있는 갓이 'smart'라면 1반환.
		// 아니라면 0 반환
	 	// 반환 --> PrintWriter객체를 통해서 가능하다!!.
	 	PrintWriter out = response.getWriter();
	 			
	 	// 회원정보 전달
	 	//이름, 나이 , 전화번호, 이메일
	 	// myList -> 데이터 set
	 	ArrayList<Member2> myList = new ArrayList<Member2>();
	 	myList.add(new Member2("승환1", 20,"01047685180", "naver"));
	 	myList.add(new Member2("승환2", 30,"01047685180", "naver"));
	 	myList.add(new Member2("승환3", 40,"01047685180", "naver"));
	 	myList.add(new Member2("승환4", 50,"01047685180", "naver"));
	 	myList.add(new Member2("승환5", 60,"01047685180", "naver"));
	 	
	 	// 여러개의 데이터를 한번에 넘길때 사용하는게 Gson
	 	// 자바스크립트에서 바로 사용할수 있더록  -> json 객체로 넘긴다!!.
	 	// gson --> java의 객체를 json객체로 변환 시키는 기능!.
	 	Gson gson = new Gson();	 	
	 	
	 	if(id.equals("smart")) {
	 		// gson.toJson(myList): myList를 json 형식으로 변환.
	 		out.print(gson.toJson(myList));
	 	} else {
	 		out.print(0);
	 	}
		
		
	}

}
