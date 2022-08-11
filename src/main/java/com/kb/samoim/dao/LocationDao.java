package com.kb.samoim.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kb.samoim.model.Location;

import java.util.List;

@Mapper
public interface LocationDao {
	
	List<Location> getLocationList(); //전체 호출
	List<Location> getCityList(); //도시만 호출
	
}