package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class insuranceDto {
	
	private String class_category; // join class.small_category
	private String url;
	
}
