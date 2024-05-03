package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor // 모든 필드값이들어가는 생성자까지 나옴.
@NoArgsConstructor // 매개변수가 없는 기본생성자를 만들겠다!.
public class MessageaDTO {
	private int num;
	private String sendNmae;
	private String reciveEmail;
	private String message;
	private String m_date;
	
	
	
	

}
