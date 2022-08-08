package com.kb.samoim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.samoim.dao.classDao;
import com.kb.samoim.dto.classDto;

import java.util.List;

@Service
public class classService {
	
	@Autowired
	private classDao classdao;

	public List<classDto> getClassListService(){
		return classdao.selectClassAll();
	}
	
	
}
