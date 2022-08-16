package com.kb.samoim.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.ClassDao;
import com.kb.samoim.dao.UserDao;
import com.kb.samoim.dto.ClassCompleteDto;
import com.kb.samoim.dto.ClassDto;
import com.kb.samoim.dto.ClassMeetDto;
import com.kb.samoim.dto.UserDto;

@Service
public class ClassService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassService.class);
	private ClassDao classDao;
	private UserDao userDao;
	public ClassService(
			@Autowired
			ClassDao classDao,
			UserDao userDao
	) {
		this.classDao = classDao;
		this.userDao = userDao;
	}
	
	
	public ClassDto createClass(String user_id, ClassDto classDto) {
		
		ClassDto newClass = new ClassDto();
		newClass.setName(classDto.getName());
		newClass.setLarge_category(classDto.getLarge_category());
		newClass.setSmall_category(classDto.getSmall_category());
		newClass.setCity(classDto.getCity());
		newClass.setAddress(classDto.getAddress());
		newClass.setMax_member(classDto.getMax_member());
		newClass.setOwner_id(user_id);
		newClass.setOpen_date(classDto.getOpen_date());
		newClass.setDetail_contents(classDto.getDetail_contents());
		newClass.setPhoto_path(classDto.getPhoto_path());
		this.classDao.createClass(newClass);
		
		return newClass;
	}
	
	
	public ClassCompleteDto completedClass(String email) {
		ClassCompleteDto resultDto = new ClassCompleteDto();
		ClassCompleteDto findClass = this.classDao.completedClass(email);
		if(findClass == null) {
			logger.info("참석 완료한 모임 찾기 실패");
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);	
		}
		
		logger.info("참석 완료 모임 조회 성공");
		resultDto.setName(findClass.getName());
		resultDto.setCity(findClass.getCity());
		resultDto.setAddress(findClass.getAddress());
		resultDto.setPoint(findClass.getPoint());
		
		return resultDto;
	}
	
	public ClassDto getMyCreateClass(String email) {
		UserDto findUser = this.userDao.findByEmail(email);
		if(findUser == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		ClassDto myClass = this.classDao.getMyCreateClass(email);
		ClassDto emptyClass = new ClassDto();
		if(myClass == null) {
			logger.info("내가 만든 모임이 없는 경우");
			return emptyClass;
		}
		else {
			return myClass;
		}
	}
	
	public ClassMeetDto createClassMeet(String email, ClassMeetDto classMeetDto) {
		UserDto findUser = this.userDao.findByEmail(email);
		if(findUser == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		ClassMeetDto newClassMeetDto = new ClassMeetDto();
		
		
		
		return newClassMeetDto;
	}
	
//	public CalendarDto selectClassByDate(String email,String date) {
//		CalendarDto resultDto = new CalendarDto();
//		CalendarDto findDto = this.classDao.selectClassByDate(email, date);
//		if(findDto == null) {
//			logger.info("해당 날짜에는 데이터가 없는 것");
//			return null;
//		}
//		
//		resultDto.setClassName(findDto.getClassName());
//		resultDto.setDate(findDto.getDate());
//		resultDto.setCity(findDto.getCity());
//		resultDto.setAddress(findDto.getAddress());
//		
//		
//		return resultDto;
//	}
}
