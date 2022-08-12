package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.UserDto;

@Mapper
public interface UserDao {
	
	void saveUser(UserDto userDto); //유저 저장
	boolean updateInterest(String email, String interest); //유저 관심사 업데이트
	UserDto updateUser(String email, UserDto userDto); //유저 정보 업데이트
	UserDto findByEmail(String email); //이메일로 유저 정보 찾기
	UserDto getUserPoint(String email); //유저 정보 + 포인트 조회
	void addPoint(String email, int point);
	
}