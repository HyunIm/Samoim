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
public class userDto {
	private String email; // 이메일
	private String name; // 이름
	private String phone; // 전화번호
	private String password; //비밀번호
	private String gender;
	private String date;
	private String city;
	private String address;
	private String interest;
	private String photo_path;
	private String tag;
}
