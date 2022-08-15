package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ClassCompleteDto {
	
	public ClassCompleteDto() {
		
	}
	
	private String name;
	private String city;
	private String address;
	private int point;
	
}
