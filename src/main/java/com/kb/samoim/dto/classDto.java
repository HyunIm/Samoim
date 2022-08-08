package com.kb.samoim.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class classDto {
	
	private Long id;
	private String name;
	private String large_category;
	private String small_category;
	private String city;
	private String address;
	private String max_member;
	private String owener_id; // USER Email
	private String open_date;
	private String detail_contents;
	private String photo_path;
	
}
