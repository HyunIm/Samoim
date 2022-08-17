package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassDetailDto {
	
	private int id;
	private String name;
	private String city;
	private String address;
	private String openDate;
	private int person;
	private int maxMember;
	private String photoPath;
	
}
