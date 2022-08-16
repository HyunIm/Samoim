package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.dto.SCategoryDto;

@Mapper
public interface RecommendDao {
	
	int createRecommend(String email); //추천 return
	SCategoryDto getRecommendData(int code);
	
}
