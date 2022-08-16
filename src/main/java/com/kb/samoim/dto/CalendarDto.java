package com.kb.samoim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CalendarDto {
	
	public CalendarDto(){
		
	}
	
	private int id; //Auto Increment
	private String userName; //유저이름
	private String userEmail; //유저이메일
	
	private int classId; //클래스 아이디
	private String className; //클래스 이름
	private String City; //클래스 장소
	private String address; //클래스 
	private String state; //진행 상태 table = CLASS_MEET
	
	private String date; //날짜
	
}
