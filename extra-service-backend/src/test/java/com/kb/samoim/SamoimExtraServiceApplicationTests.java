package com.kb.samoim;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kb.samoim.insurance.Insurance;
import com.kb.samoim.insurance.InsuranceRepository;

@SpringBootTest
class SamoimExtraServiceApplicationTests {
	
	@Autowired
	private InsuranceRepository redisRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void insuranceTest() {
		// Create
		/*
		Insurance insurance = new Insurance(null, "운동", "https://m.kbinsure.co.kr:8543/main.ec");
		
		redisRepository.save(insurance);
		*/
		
		// Read
		/*
		Iterable<Insurance> insurance = redisRepository.findAll();
		
		for(Insurance test : insurance) {
			System.out.println(test.getId());
		}
		*/
		
		// Delete
		/*
		Iterable<Insurance> insurance = redisRepository.findAll();
		
		for(Insurance test : insurance) {
			redisRepository.deleteById(test.getId());
		}
		*/
	}
}
