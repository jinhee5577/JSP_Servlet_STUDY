package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public class Board {

	private int num; // 인덱스
	@NonNull private String title; // 제목
	@NonNull private String writer; // 작성자
	@NonNull private String filename; // 파일이름
	@NonNull private String content; // 내용
	private String b_date; // 업로드 시각
	
}
