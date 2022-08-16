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
public class UserDto {

	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	private String email;
	private String name;
	private String phone;
	private String password;
	private String gender;
	private String birth;
	private String city;
	private String address;
	private String interest;
	private String photo_path;
	private String tag;
	private int point;
	
}
