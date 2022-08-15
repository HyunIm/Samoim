package com.kb.samoim.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.CategoryDao;
import com.kb.samoim.model.Category;

@Service
public class CategoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	private CategoryDao categoryDao;
	
	public CategoryService(
			@Autowired CategoryDao categoryDao
	) {
		this.categoryDao = categoryDao;
	}
	
}
