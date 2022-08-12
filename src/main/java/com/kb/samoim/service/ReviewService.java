package com.kb.samoim.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.ReviewDao;
import com.kb.samoim.dto.ReviewDto;

@Service
public class ReviewService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
	private final ReviewDao reviewDao;
	
	public ReviewService(
			@Autowired ReviewDao reviewDao
	) {
		this.reviewDao = reviewDao;
	}
	
	public boolean createReview(String user_id,int class_id,ReviewDto reviewDto) {
		ReviewDto newReviewDto = new ReviewDto();
		if(reviewDto.getClass_id() != class_id) {
			logger.info("class_ID 불일치");
			return false;
		}
		if(!reviewDto.getUser_id().equals(user_id)) {
			logger.info("user email 불일치");
			return false;
		}
		
		newReviewDto.setClass_id(class_id);
		newReviewDto.setUser_id(user_id);
		newReviewDto.setScore(reviewDto.getScore());
		newReviewDto.setContents(reviewDto.getContents());
		this.reviewDao.createReview(newReviewDto);
		logger.info(""+newReviewDto.getContents()+"제발 저장되라");
		
		return true;
	}
	
	public List<ReviewDto> getReviewAll(int class_id){
		List<ReviewDto> reviewList = null;
		try {
			logger.info("Review List 검색");
			reviewList = this.reviewDao.getReviewAll(class_id);
		}
		catch (Exception e) {
			logger.info("잘못된 class_id");
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		logger.info("class_id에 일치하는 Review List 조회 성공");
		return reviewList;
	}
	
}
