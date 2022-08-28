package com.kb.samoim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dto.ReviewDto;
import com.kb.samoim.service.ReviewService;

@RestController("review")
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger("ReviewController.class");
	private final ReviewService reviewService;
	public ReviewController(
			@Autowired
			ReviewService reviewService
	) {
		this.reviewService = reviewService;
	}
	
	@PostMapping("/{user_id}/{class_id}")
	public ResponseEntity<?> createReview(
			@PathVariable String user_id, //유저 이메일
			@PathVariable int class_id, //클래스 아이디
			@RequestBody ReviewDto reviewDto
	){
		logger.info("클래스 ID " + class_id + " User Email " + user_id +" Review 작성 성공!");
		return ResponseEntity.ok(this.reviewService.createReview(user_id,class_id,reviewDto));
	}
	
	@GetMapping("/review/{class_id}")
	public ResponseEntity<?> getReviewAll(
			@PathVariable int class_id
	){
		List<ReviewDto> findList = this.reviewService.getReviewAll(class_id);
		if(findList.isEmpty() || findList.size()==0) {
			logger.info("리뷰가 없음");
		}
		else {
			logger.info("리뷰 개수 " + findList.size());
		}
		return ResponseEntity.ok(findList);
	}
	
}
