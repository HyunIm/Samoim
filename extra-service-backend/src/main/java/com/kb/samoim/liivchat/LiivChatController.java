package com.kb.samoim.liivchat;

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
public class LiivChatController {
	
	@Autowired
	private LiivChatRepository redisRepository;
	
	@ApiOperation(value = "리브똑똑 URL 정보 가져오기")
	@GetMapping(value = "/liivchat/url")
	public ResponseEntity<LiivChat> getLiivChatUrl(@RequestParam String classId) {
		log.debug("getLiivChatUrl => {}", classId);
		
		if(ObjectUtils.isEmpty(classId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			Optional<LiivChat> liivChat = redisRepository.findById(classId);
			
			if(ObjectUtils.isEmpty(liivChat)) {
				return new ResponseEntity<>(null, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(liivChat.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value = "/liivchat/save", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LiivChat> saveLiivChatUrl(@RequestBody LiivChatVo request){
		log.debug("saveLiivChatUrl => {}", request);
		
		if(ObjectUtils.isEmpty(request.getClassId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			LiivChat liivChat = new LiivChat(request.getClassId(), request.getUrl());
			
			redisRepository.save(liivChat);
			
			return new ResponseEntity<>(liivChat, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping(value = "/liivchat/delete", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LiivChat> deleteLiivChatUrl(@RequestParam String classId) {
		log.debug("deleteLiivChatUrl => {}", classId);
		
		if(ObjectUtils.isEmpty(classId)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		try {
			redisRepository.deleteById(classId);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@DeleteMapping(value = "/liivchat/delete/all")
	public ResponseEntity<LiivChat> deleteAllLiivChatInfo() {
		log.debug("deleteAllLiivChatInfo");
		
		try {
			Iterable<LiivChat> liivChat = redisRepository.findAll();
			
			for(LiivChat obj : liivChat) {
				redisRepository.delete(obj);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
}
