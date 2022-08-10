package com.kb.samoim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dao.ClassJoinDao;
import com.kb.samoim.model.ClassJoin;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClassJoinController {

	@Autowired
	private ClassJoinDao classJoinDao;

	@ApiOperation(value = "모임 참가")
	@PostMapping(value = "/join")
	public ResponseEntity<String> insertClassJoin(@RequestBody ClassJoin classJoin) {
		int rc = 0;
		String msg = null;

		try {
			rc = classJoinDao.insertClassJoin(classJoin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (rc > 0) {
			msg = "모임 참가 완료";
		}

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
