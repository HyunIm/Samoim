package com.kb.samoim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dto.RecommendDto;
import com.kb.samoim.dto.SCategoryDto;
import com.kb.samoim.service.RecommendService;

import io.swagger.annotations.ApiOperation;

@RestController
public class RecommendController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecommendController.class);
	private RecommendService recommendService;
	
	public RecommendController(
			@Autowired RecommendService recommendService
	) {
		this.recommendService = recommendService;
	}
	
	
	//이거는 ML 서버랑 통신하려고 만든 API
	@ApiOperation("추천 생성 API (ML서버랑 통신)")
	@GetMapping("/recommend/{email}")
	public ResponseEntity<Integer> createRecommend(
			@PathVariable String email
	){
		try {
			System.out.println("시작");
			this.recommendService.createRecommend(email);	
			
		}
		catch (Exception e) {
			logger.info("연결 실패");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(null);
	}
	
	
	@ApiOperation("추천 항목 데이터 불러오기 API")
	@GetMapping("/recommend")
	public ResponseEntity<SCategoryDto> getRecommendData(
			@RequestBody int code
			//@PathVarialbe int code
	){
		return ResponseEntity.ok(this.recommendService.getRecommendData(code));
	}

}
