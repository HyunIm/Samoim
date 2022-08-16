package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.CalendarDto;
import com.kb.samoim.dto.ClassCompleteDto;
import com.kb.samoim.dto.ClassDto;
import com.kb.samoim.dto.ClassMeetDto;
import com.kb.samoim.model.Class;

@Mapper
public interface ClassDao {
	List<Class> selectClassAll();

	Class selectClass(long id);

	List<Class> selectClassByFilter(List<String> category, List<String> area);
	
	boolean createClass(ClassDto classDto); //모임 생성 API
	
	ClassCompleteDto completedClass(String email); 
	
	//내가 개설한 모임
	ClassDto getMyCreateClass(String email);
	
	//모임 상태 체크
	ClassMeetDto createClassMeet(ClassMeetDto classMeetDto);
	
	//나중에
	CalendarDto selectClassByDate(String email,String date);
}
