package com.kb.samoim.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dto.ClassDto;
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
	@PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
		return ResponseEntity.ok(null);
	}
	
	@ApiOperation("로그인 페이지")
	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
	
	@ApiOperation("로그인 API")
	@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean loginUser(
			@RequestBody UserDto loginData
	){
		boolean flag = this.userService.loginUser(loginData);
		if(flag) {
			logger.info("로그인 성공");
			return flag;
		}
		
		//실패하면 다시 로그인 페이지로 보냄
		logger.info("로그인 실패");
		return flag;
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
	@PutMapping(value="/user/interest", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateInterest(@RequestBody UserDto userDto){
		return ResponseEntity.ok(this.userService.updateInterest(userDto.getEmail(), userDto.getInterest()));
	}
	
	@ApiOperation("마이페이지 회원 정보 수정 API")
	@PutMapping(value="/myPage/modify", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
		return ResponseEntity.ok(this.userService.updateUser(userDto.getEmail(), userDto));
	}
	
	@ApiOperation("유저 포인트 및 정보 함께 조회 API")
	@GetMapping("/balance/{email}")
	public ResponseEntity<Integer> getUserPoint(
			@PathVariable String email
	){
		return ResponseEntity.ok(this.userService.getUserPoint(email).getPoint());
	}
	
	@ApiOperation("포인트 업데이트 API")
	@PutMapping(value="/balance/update", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pointUpdate(@RequestBody UserDto userDto){
		boolean flag = this.userService.updatePoint(userDto.getEmail(), userDto.getPoint());
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
	
	@ApiOperation("유저 정보 get API")
	@GetMapping("/info/{email}")
	public ResponseEntity<?> getUserInfo(
			@PathVariable String email
	){
		return ResponseEntity.ok(this.userService.getUserInfo(email));
	}
	
	@ApiOperation("내가 가입한 모임 목록 조회 API")
	@GetMapping("/myJoinClass/{email}")
	public ResponseEntity<List<ClassDto>> getMyJoinClass(
			@PathVariable String email
	){
		return ResponseEntity.ok(this.userService.getMyJoinClass(email));
	}
}
