package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Message {
	
	private int num;
	private String sendName;
	private String receiveEmail;
	private String message;
	private String m_date;

}
