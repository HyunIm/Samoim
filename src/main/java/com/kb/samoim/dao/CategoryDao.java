package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.model.Category;

@Mapper
public interface CategoryDao {
	
	List<Category> selectCategoryAll();
	
}
