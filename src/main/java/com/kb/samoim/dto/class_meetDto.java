package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class class_meetDto {
	
	private Long id;
	private int class_id;
	private String state;
	private String price;
	private String date;
	
}
