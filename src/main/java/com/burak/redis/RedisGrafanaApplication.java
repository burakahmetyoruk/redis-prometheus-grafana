package com.burak.redis;

import com.burak.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SpringBootApplication
public class RedisGrafanaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedisGrafanaApplication.class, args);
	}

	@Autowired
	private RedisService redisService;

	@Override
	public void run(String... args) {


		List<Long> longList =  createRandomList();

		Map<String, String > stringMap = new HashMap<>();
		for (Long l : longList) {
			stringMap.put(l.toString(), l.toString());
		}

		//redisService.storeMapToRedis(stringMap);
		redisService.deleteFromRedis("Key1");
	}

	public List<Long> createRandomList() {
		return randomStream(1_000_000, 100000).collect(Collectors.toList());
	}


	public Stream<Long> randomStream(long streamSize, int range) {

		return new Random().longs(streamSize,0,range).boxed();

	}
}
