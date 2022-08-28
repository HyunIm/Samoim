package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassMeetDto {
	
	private int id;
	private int class_id;
	private int state;
	private int price;
	private String date;
	
}
