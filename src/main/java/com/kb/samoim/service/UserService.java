package com.kb.samoim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.UserDao;
import com.kb.samoim.dto.UserDto;

@Service
public class UserService {

	private UserDao userDao;
	
	public UserService(
			@Autowired UserDao userDao		
	) {
		this.userDao = userDao;
	}
	
	public void saveUser(UserDto userDto) {
		
		UserDto newUser = new UserDto();
		newUser.setEmail(userDto.getEmail());
		newUser.setName(userDto.getName());
		newUser.setPhone(userDto.getPhone());
		newUser.setPassword(userDto.getPassword());
		newUser.setBirth(userDto.getBirth());
		newUser.setGender(userDto.getGender());
		newUser.setCity(userDto.getCity());
		newUser.setAddress(userDto.getAddress());
		newUser.setInterest(userDto.getInterest());
		
		this.userDao.saveUser(newUser);
	}

	public UserDto findByEmail(String email) {
		UserDto findUser = new UserDto();
		UserDto userdto = this.userDao.findByEmail(email);	
		
		if(userdto == null)
			throw new NullPointerException();
		
		findUser.setEmail(userdto.getEmail());
		findUser.setName(userdto.getName());
		findUser.setCity(userdto.getCity());
		findUser.setAddress(userdto.getAddress());
		
		return userdto;
		
	}
	
	public boolean updateInterest(String email, String interest) {
		UserDto findUser = this.userDao.findByEmail(email);
		if(findUser == null) 
			return false;
		
		this.userDao.updateInterest(email, interest);
		
		return true;
	}
	
	public UserDto updateUser(String email, UserDto userDto) {
		UserDto newUserDto = new UserDto();
		UserDto findUser = this.userDao.findByEmail(email);
		if(findUser == null)
			return null;
		
		newUserDto.setName(userDto.getName()!=null ? findUser.getName() : userDto.getName());
		newUserDto.setPhone(userDto.getPhone()!=null ? findUser.getPhone() : userDto.getPhone());
		newUserDto.setPhoto_path(userDto.getPhoto_path()!=null ? findUser.getPhoto_path() : userDto.getPhoto_path());
		
		return newUserDto;
	}
	
}
