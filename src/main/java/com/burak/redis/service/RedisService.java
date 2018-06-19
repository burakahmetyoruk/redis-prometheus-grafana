package com.burak.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

	@Value("${redis.tokenusername.expire.minutes:2}")
	private int timeoutValue;

	private final RedisTemplate<String, String> redisTemplate;

	public void storeToRedis(String key, String value) {
		this.redisTemplate.opsForValue().set(key, value, timeoutValue, TimeUnit.MINUTES);
	}

	public void storeMapToRedis(Map<String, String> stringMap) {
		this.redisTemplate.opsForValue().multiSet(stringMap);

	}

	public void getFromRedis(String key) {
		this.redisTemplate.opsForValue().get(key);
	}

	public void deleteFromRedis(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
	}

}