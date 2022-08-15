package com.kb.samoim.insurance;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;

@Data
@RedisHash("insurance")
public class Insurance {
	
	@Id
	String category;
	
	String url;
	
	@Builder
	public Insurance(String category, String url) {
		this.category = category;
		this.url = url;
	}
}
