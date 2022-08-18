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
		newClass.setLargeCategory(classDto.getLargeCategory());
		newClass.setSmallCategory(classDto.getSmallCategory());
		newClass.setCity(classDto.getCity());
		newClass.setAddress(classDto.getAddress());
		newClass.setMaxMember(classDto.getMaxMember());
		newClass.setOwnerId(user_id);
		newClass.setOpenDate(classDto.getOpenDate());
		newClass.setDetailContents(classDto.getDetailContents());
		newClass.setPhotoPath(classDto.getPhotoPath());
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
	
	public List<ClassDto> getMyCreateClass(String email) {
		UserDto findUser = this.userDao.findByEmail(email);
		if(findUser == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		List<ClassDto> myClass = this.classDao.getMyCreateClass(email);
		
		List<ClassDto> emptyClass = new ArrayList<>();
		if(myClass == null) {
			logger.info("내가 만든 모임이 없는 경우");
			return emptyClass;
		}
		else {
			return myClass;
		}
	}
	
	//현재 참석 인원 명수 조회
	public int getPresentJoinMember(int class_id) {
		return this.classDao.getPresentJoinMember(class_id);
	}

	//현재 모임 인원 +1 하기 
	public boolean addCurrentMember(long class_id){
		
		int flag = this.classDao.addCurrentMember(class_id);
		if(flag==1){
			logger.info("모임 인원 추가 성공");
			return true; 
		}
		else{
			logger.info("모임 인원 꽉차서 실패하는 경우");
			return false;
		}
	}

	// public ClassMeetDto createClassMeet(ClassMeetDto classMeetDto){
	// 	ClassMeetDto findClassMeet = new ClassMeetDto();

	// }
	
	
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
