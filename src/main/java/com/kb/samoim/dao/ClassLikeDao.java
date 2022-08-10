package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.model.ClassLike;

@Mapper
public interface ClassLikeDao {
	int insertClassLike(ClassLike classLike);

	int deleteClassLike(ClassLike classLike);
}
