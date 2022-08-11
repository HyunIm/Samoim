package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.UserDto;

@Mapper
public interface UserDao {
	
	void saveUser(UserDto userDto);
	boolean updateInterest(String email, String interest);
	UserDto updateUser(String email, UserDto userDto);
	UserDto findByEmail(String email);
	
}