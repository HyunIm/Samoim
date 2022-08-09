package com.kb.samoim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dao.CategoryDao;
import com.kb.samoim.model.Category;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;

	@ApiOperation(value = "카테고리 목록 정보 가져오기")
	@GetMapping(value = "/categories")
	public ResponseEntity<List<Category>> getCategoryAll() {
		List<Category> list = null;
		try {
			list = categoryDao.selectCategoryAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
}
