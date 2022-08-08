package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.classDto;

import java.util.List;

@Mapper
public interface classDao {
	
	List<classDto> selectClassAll(); //모임 리스트 전체 조회
	List<classDto> selectClass(String className); //클래스 명으로 모임 리스트 조회
	List<classDto> selectClass(String large_category, String small_category);
	
}
