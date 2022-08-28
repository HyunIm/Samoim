package com.kb.samoim.insurance;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InsuranceController {
	
	@Autowired
	private InsuranceRepository redisRepository;
	
	@ApiOperation(value = "보험 URL 정보 가져오기")
	@GetMapping(value = "/insurance/url")
	public ResponseEntity<Insurance> getInsuranceUrl(@RequestParam String category) {
		log.debug("getInsuranceUrl => {}", category);
		
		if(ObjectUtils.isEmpty(category)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Optional<Insurance> insurance = redisRepository.findById(category);
			
			if(ObjectUtils.isEmpty(insurance)) {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(insurance.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value = "/insurance/save", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Insurance> saveInsuranceUrl(@RequestBody InsuranceVo request){
		log.debug("saveInsuranceUrl => {}", request);
		
		if(ObjectUtils.isEmpty(request.getCategory())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Insurance insurance = new Insurance(request.getCategory(), request.getUrl());
			
			redisRepository.save(insurance);
			
			return new ResponseEntity<>(insurance, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping(value = "/insurance/delete", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Insurance> deleteInsuranceUrl(@RequestParam String category) {
		log.debug("deleteInsuranceUrl => {}", category);
		
		if(ObjectUtils.isEmpty(category)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			redisRepository.deleteById(category);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@DeleteMapping(value = "/insurance/delete/all")
	public ResponseEntity<Insurance> deleteAllInsuranceInfo() {
		log.debug("deleteAllInsuranceInfo");
		
		try {
			Iterable<Insurance> insurance = redisRepository.findAll();
			
			for(Insurance obj : insurance) {
				redisRepository.delete(obj);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
}
