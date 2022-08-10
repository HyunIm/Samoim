package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.model.ClassJoin;

@Mapper
public interface ClassJoinDao {
	int insertClassJoin(ClassJoin classJoin);
}
