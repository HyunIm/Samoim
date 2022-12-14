package com.kb.samoim.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.ClassDao;
import com.kb.samoim.dao.UserDao;
import com.kb.samoim.dto.ClassDto;
import com.kb.samoim.dto.UserDto;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private UserDao userDao;
	
	public UserService(
			@Autowired UserDao userDao
	) {
		this.userDao = userDao;
	}
	
	public void saveUser(UserDto userDto) {
		//회원가입시 중복 체크하는 로직 필요
		
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
		newUser.setPoint(100000);
		newUser.setPhotoPath(userDto.getPhotoPath());
		
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
		newUserDto.setPhotoPath(userDto.getPhotoPath()!=null ? findUser.getPhotoPath() : userDto.getPhotoPath());
		
		return newUserDto;
	}
	
	public UserDto getUserPoint(String email) {
		UserDto findUser = null;
		findUser = this.userDao.findByEmail(email);	
		if(findUser == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return this.userDao.getUserPoint(findUser.getEmail());
	}
	
	public boolean updatePoint(String email, int point) {
		UserDto findUser = null;
		findUser = this.userDao.findByEmail(email);
		if(findUser == null)
			return false;
		int balance = findUser.getPoint();
		int diff = balance - point;
		if(diff<0)
			return false;
		
		this.userDao.updatePoint(email,diff);
		
		return true;
	}

	public boolean emailCheck(String email) {
		UserDto findUser = this.userDao.findByEmail(email);
		int flag = this.userDao.emailCheck(email);
		
		if(findUser != null || flag!=0) {
			logger.info("이미 가입된 이메일이 있음");
			return false;
		}
		return true;
	}
	
	public boolean loginUser(UserDto loginData) {
		UserDto findUser = this.userDao.findByEmail(loginData.getEmail());
		if(findUser == null) {
			logger.info("해당 이메일 없는 경우");
			return false;
		}
		
		if(!loginData.getPassword().equals(findUser.getPassword())) {
			logger.info("비밀번호 불일치");
			return false;
		}
		
		return true;

	}
	
	public UserDto getUserInfo(String email) {
		UserDto findUser = new UserDto();
		
		findUser = this.userDao.findByEmail(email);
		System.out.println(findUser);
		if(findUser == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return findUser;
	}
	
	//내가 가입한 모임 목록
	public List<ClassDto> getMyJoinClass(String email) {
		List<ClassDto> emptyClass = new ArrayList<>();
		List<ClassDto> myJoinClass = this.userDao.getMyJoinClass(email);
		
		if(myJoinClass == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		if(myJoinClass.isEmpty() || myJoinClass.size()==0) {
			logger.info("가입한 모임이 없는 경우");
			return emptyClass;
		}
		return myJoinClass;
	}
}
