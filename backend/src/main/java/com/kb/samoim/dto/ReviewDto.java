package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDto {
	
	private int class_id; //클래스 id
	private String user_id; //유저 email
	private int score;
	private String contents;
	private String photo_path;
	private String create_date;
	
}
