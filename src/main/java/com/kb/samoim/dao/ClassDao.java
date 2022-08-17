package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.CalendarDto;
import com.kb.samoim.dto.ClassCompleteDto;
import com.kb.samoim.dto.ClassDetailDto;
import com.kb.samoim.dto.ClassDto;
import com.kb.samoim.dto.ClassMeetDto;
import com.kb.samoim.model.Class;

@Mapper
public interface ClassDao {
	
	List<Class> selectClassAll();
	ClassDetailDto getDetailDataAll(); //모임 상세 정보 불러오기
		
	Class selectClass(long id);
		
	List<Class> selectClassByFilter(List<String> category, List<String> area); 	//모임 상세 정보 불러오기
	
	boolean createClass(ClassDto classDto); //모임 생성 API
	
	ClassCompleteDto completedClass(String email); 
	
	//내가 개설한 모임
	List<ClassDto> getMyCreateClass(String email);
	
	//모임 상태 체크
	int getPresentJoinMember(int class_id);
	
	//모임 현재 인원 + 1
	int addCurrentMember(long class_id);
	
	//모임 모임 개설할때 모임 만나는 정보도 같이 INSERT하는 인터페이스
	ClassMeetDto createClassMeet(ClassMeetDto classMeetDto);

	//나중에
	CalendarDto selectClassByDate(String email,String date);
}
