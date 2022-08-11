package com.kb.samoim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.samoim.dao.LocationDao;
import com.kb.samoim.model.*;

import io.swagger.annotations.ApiOperation;
import java.util.List;


@RestController("location")
public class LocationController {
	
	@Autowired
	private LocationDao locationDao;
	
	
	
	@ApiOperation("Location 전체 호출 API")
	@GetMapping("/location")
	public ResponseEntity<List<Location>> getAddressList(){
		List<Location> locationList = locationDao.getLocationList();
		return ResponseEntity.ok(locationList);
	}
	
	@ApiOperation("도시만 호출 API")
	@GetMapping("/city")
	public ResponseEntity<List<Location>> getCityList(){
		List<Location> cityList = locationDao.getCityList();
		return ResponseEntity.ok(cityList);
	}
	
}