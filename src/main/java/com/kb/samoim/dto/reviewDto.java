package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class reviewDto {
	
	private Long id;
	private userDto userdto;
	private classDto classdto;
	private int score;
	private String contents;
	private String photo_path;
	private String create_dat;
	
}
