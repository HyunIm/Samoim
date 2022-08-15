package com.kb.samoim.liivchat;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;

@Data
@RedisHash("liivchat")
public class LiivChat {
	
	@Id
	String classId;
	
	String url;
	
	@Builder
	public LiivChat(String classId, String url) {
		this.classId = classId;
		this.url = url;
	}
}
