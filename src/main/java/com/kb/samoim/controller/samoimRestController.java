package com.kb.samoim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dto.classDto;
import com.kb.samoim.service.classService;
import java.util.List;

@RestController("")
public class samoimRestController {
	private static final Logger logger = LoggerFactory.getLogger(samoimRestController.class);
	private classService classsservice;
	
	@GetMapping("/test")
	public String getPage() {
		return "hello world";
	}
	
	@GetMapping("/class")
	public ResponseEntity getClassList() {
		List<classDto> classList = this.classsservice.getClassListService();
		return new ResponseEntity<List<classDto>>(classList, HttpStatus.OK);
	}
	
}