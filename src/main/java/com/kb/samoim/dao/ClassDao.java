package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.ClassCompleteDto;
import com.kb.samoim.dto.ClassDto;
import com.kb.samoim.model.Class;

@Mapper
public interface ClassDao {
	List<Class> selectClassAll();

	Class selectClass(long id);

	List<Class> selectClassByFilter(List<String> category, List<String> area);
	
	boolean createClass(ClassDto classDto); //모임 생성 API
	
	ClassCompleteDto completedClass(String email);
	
}
