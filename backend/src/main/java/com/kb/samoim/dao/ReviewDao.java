package com.kb.samoim.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.kb.samoim.dto.ReviewDto;

@Mapper
public interface ReviewDao {
	
	boolean createReview(ReviewDto reviewDto); //리뷰 작성
	List<ReviewDto> getReviewAll(int class_id); //해당 클래스의 리뷰 전체 불러오기
	
}
