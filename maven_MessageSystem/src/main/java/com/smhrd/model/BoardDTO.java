package com.smhrd.model;

import lombok.Data;

@Data
public class BoardDTO {
 	private int num;
 	private String titel;
 	private String writer;
 	private String filename;
 	private String content;
 	private String b_date;

	// 디폴트 생성자
    public BoardDTO() {
    	
    }



}
