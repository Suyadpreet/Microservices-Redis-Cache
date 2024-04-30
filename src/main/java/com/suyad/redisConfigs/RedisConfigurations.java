package com.suyad.redisConfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.suyad.models.Books;

@Configuration
public class RedisConfigurations
{
	@Bean
	public JedisConnectionFactory jedisConnFactory()
	{
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		
		
		return jcf;
	}
	
	@Bean
	public RedisTemplate<String,Books> redisTemplate()
	{
		RedisTemplate<String,Books> redisTemplate = new RedisTemplate<>();
		
		redisTemplate.setConnectionFactory(jedisConnFactory());
		
		return redisTemplate;
	}
}
