package com.kb.samoim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dto.UserDto;
import com.kb.samoim.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

    public UserController(
    		@Autowired UserService userService
    ) {    
    	this.userService = userService;
    }
	
    @ApiOperation("회원가입 페이지 GET API")
	@GetMapping("/signUp")
	public String saveUser() {
		return "user/signup"; //signUp 
	}
	
	@ApiOperation("회원가입 API")
	@PostMapping("/signUp")
	public ResponseEntity<UserDto> saveUser(UserDto userDto) {
		userService.saveUser(userDto);
		return ResponseEntity.ok(null);
	}
	
	@ApiOperation("Email로 User찾기 API")
	@GetMapping("/user/{email}")
	public ResponseEntity<UserDto> findByEmail(
			@PathVariable String email
	){
		if(this.userService.findByEmail(email)==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.userService.findByEmail(email));
	}

	@ApiOperation("관심사(INTEREST) 수정(등록)하기 API")
	@PutMapping("/user/{email}")
	public ResponseEntity<?> updateInterest(
			@PathVariable String email,
			@RequestBody String interest
	){
		return ResponseEntity.ok(this.userService.updateInterest(email, interest));
	}
	
	@ApiOperation("마이페이지 회원 정보 수정 API")
	@PutMapping("/myPage/{email}")
	public ResponseEntity<?> updateUser(
			@PathVariable String email,
			@RequestBody UserDto userDto
	){
		return ResponseEntity.ok(this.userService.updateUser(email, userDto));
	}
	
	@ApiOperation("유저 포인트 및 정보 함께 조회 API")
	@GetMapping("/balance/{email}")
	public ResponseEntity<Integer> getUserPoint(
			@PathVariable String email
	){
		return ResponseEntity.ok(this.userService.getUserPoint(email).getPoint());
	}
	
	@ApiOperation("포인트 업데이트 API")
	@PutMapping("/balance/update/{email}")
	public ResponseEntity<?> pointUpdate(
			@PathVariable String email,
			@RequestBody int price // 가격 
	){
		boolean flag = this.userService.updatePoint(email, price);
		if(!flag) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		return ResponseEntity.ok(flag);
	}
	
	@ApiOperation("이메일 중복체크")
	@GetMapping("/emailCheck/{email}")
	public ResponseEntity<?> emailDuplicateCheck(
			@PathVariable String email
	){
		boolean flag = this.userService.emailCheck(email);
		if(!flag) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		logger.info("가입 가능");
		return ResponseEntity.ok(flag);
	}
}
