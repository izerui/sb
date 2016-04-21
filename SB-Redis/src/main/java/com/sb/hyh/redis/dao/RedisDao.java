package com.sb.hyh.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.sb.hyh.component.redis.RedisClient;

@Service
public class RedisDao {
	@Autowired
	public RedisClient redisClient;

	public void test() {
		final StringRedisTemplate srt = redisClient.getRedisClient();
		String str = srt.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = srt.getStringSerializer().serialize("ext_content_rule_key");
				byte[] value = connection.get(key);
				return srt.getStringSerializer().deserialize(value);
			}
		});
		System.out.println(str);
	}
}
