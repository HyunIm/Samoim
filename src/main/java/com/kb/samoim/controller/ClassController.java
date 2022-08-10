package com.kb.samoim.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dao.ClassDao;
import com.kb.samoim.model.Class;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClassController {

	@Autowired
	private ClassDao classDao;

	@ApiOperation(value = "모임 목록 정보 가져오기 (모임 생성 최신 순으로 정렬)")
	@GetMapping(value = "/classes")
	public ResponseEntity<List<Class>> getClassAll() {
		List<Class> list = null;
		try {
			list = classDao.selectClassAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Class>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "모임 세부 정보 가져오기")
	@GetMapping(value = "/classes/{id}")
	public ResponseEntity<Class> getClass(@PathVariable long id) {
		Class cls = null;
		try {
			cls = classDao.selectClass(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Class>(cls, HttpStatus.OK);
	}

	@ApiOperation(value = "카테고리/지역 필터링에 따른 모임 목록 가져오기")
	@PostMapping(value = "/classes")
	public ResponseEntity<List<Class>> getClassByFilter(@RequestBody HashMap<String, List<String>> params) {
		List<Class> list = null;
		try {
			list = classDao.selectClassByFilter(params.get("category"), params.get("area"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Class>>(list, HttpStatus.OK);
	}
}
