package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.model.Class;
import com.kb.samoim.model.ClassLike;

@Mapper
public interface ClassLikeDao {
	int insertClassLike(ClassLike classLike);

	int deleteClassLike(ClassLike classLike);

	List<Class> selectClassLike(String userId);
}
