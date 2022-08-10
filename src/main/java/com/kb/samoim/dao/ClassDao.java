package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.model.Class;

@Mapper
public interface ClassDao {
	List<Class> selectClassAll();

	Class selectClass(long id);

	List<Class> selectClassByFilter(List<String> category, List<String> area);
}
