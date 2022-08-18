package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ClassDto {
	
	public ClassDto() {
		
	}
	
	private Long id;
	private String name;
	private String largeCategory;
	private String smallCategory;
	private String city;
	private String address;
	private String maxMember;
	private String ownerId; // USER Email
	private String openDate;
	private String detailContents;
	private String photoPath;
	private String currentmember;
	
}
