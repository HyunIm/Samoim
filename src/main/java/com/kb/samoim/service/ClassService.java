package com.kb.samoim.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kb.samoim.dao.ClassDao;
import com.kb.samoim.dto.ClassDto;

@Service
public class ClassService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassService.class);
	private ClassDao classDao;
	public ClassService(
			@Autowired
			ClassDao classDao
	) {
		this.classDao = classDao;
	}
	
	
	public ClassDto createClass(String user_id, ClassDto classDto) {
		
		ClassDto newClass = new ClassDto();
		newClass.setName(classDto.getName());
		newClass.setLarge_category(classDto.getLarge_category());
		newClass.setSmall_category(classDto.getSmall_category());
		newClass.setCity(classDto.getCity());
		newClass.setAddress(classDto.getAddress());
		newClass.setMax_member(classDto.getMax_member());
		newClass.setOwener_id(user_id);
		newClass.setOpen_date(classDto.getOpen_date());
		
		return this.classDao.createClass(user_id, classDto);
	}
	
}
