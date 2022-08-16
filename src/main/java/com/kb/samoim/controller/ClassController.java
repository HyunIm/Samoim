package com.kb.samoim.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dao.ClassDao;
import com.kb.samoim.dao.ClassJoinDao;
import com.kb.samoim.dao.ClassLikeDao;
import com.kb.samoim.dto.ClassCompleteDto;
import com.kb.samoim.dto.ClassDto;
import com.kb.samoim.model.Class;
import com.kb.samoim.model.ClassJoin;
import com.kb.samoim.model.ClassLike;
import com.kb.samoim.service.ClassService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClassController {
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	private ClassService classService;
	public ClassController(
			@Autowired
			ClassService classService
	) {
		this.classService = classService;
	}
	
	
	@Autowired
	private ClassDao classDao;

	@Autowired
	private ClassJoinDao classJoinDao;

	@Autowired
	private ClassLikeDao classLikeDao;

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

	@ApiOperation(value = "모임 찜 등록")
	@PostMapping(value = "/like")
	public ResponseEntity<String> insertClassLike(@RequestBody ClassLike classLike) {
		int rc = 0;
		String msg = null;

		try {
			rc = classLikeDao.insertClassLike(classLike);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (rc > 0) {
			msg = "모임 찜 등록 완료";
		}

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@ApiOperation(value = "모임 찜 해제")
	@PostMapping(value = "/like/delete")
	public ResponseEntity<String> deleteClassLike(@RequestBody ClassLike classLike) {
		int rc = 0;
		String msg = null;

		try {
			rc = classLikeDao.deleteClassLike(classLike);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if (rc > 0) {
			msg = "모임 찜 해제 완료";
		}

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@ApiOperation(value = "찜한 모임 리스트 가져오기")
	@GetMapping(value = "/like/{userId}")
	public ResponseEntity<List<Class>> selectClassLike(@PathVariable String userId) {
		List<Class> list = null;
		try {
			list = classLikeDao.selectClassLike(userId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Class>>(list, HttpStatus.OK);
	}
	
	@ApiOperation("모임(Class) 생성 API")
	@PostMapping("/create/{user_id}")
	public ResponseEntity<?> createClass(
			@PathVariable String user_id,
			@RequestBody ClassDto classDto
	){
		logger.info("새 클래스 생성완료");
		return ResponseEntity.ok(this.classService.createClass(user_id, classDto));
	}
	
	//상세 정보는 어떤게 들어갈지 수정 필요
	@ApiOperation("모임 참석 완료 조회 API")
	@GetMapping("/completed/{email}")
	public ResponseEntity<ClassCompleteDto> completedClass(
			@PathVariable String email
	){
		return ResponseEntity.ok(this.classService.completedClass(email));
	}
	
	@ApiOperation("내가 만든 모임 조회 API")
	@GetMapping("/myClass/{email}")
	public ResponseEntity<ClassDto> getMyCreateClass(
			@PathVariable String email
	){
		return ResponseEntity.ok(this.classService.getMyCreateClass(email));
	}
	
	@ApiOperation("날짜별 모임 참석 리스트 조회")
	@GetMapping("/dateFilter/{email}")
	public ResponseEntity<?> selectClassByDate(
			@PathVariable String email,
			@RequestBody String date
	){
		return ResponseEntity.ok(this.classService.selectClassByDate(email, date));
	}
	
}
