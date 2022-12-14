package com.kb.samoim.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Class {
	
	private long id;
	private String name;
	private String largeCategory;
	private String smallCategory;
	private String city;
	private String address;
	private long maxMember;
	private String ownerId;
	private String openDate;
	private String detailContents;
	private String photoPath;
	private int price;
	private int currentMember;
	
}

