package com.yangbo.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	/*@Bean
	public RedisConnectionFactory getFactory() {
		// 如果什么参数都不设置，默认连接本地6379端口
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPort(6379);
		factory.setHostName("localhost");
		return factory;
	}*/

	/*@Bean
	public RedisTemplate getTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>(); // 将redis连接工厂设置到模板类中
		template.setConnectionFactory(factory);
		return template;
	}
*/
	@Bean
	public RedisTemplate getJsonTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(factory);
		// 设置key的序列化，因为key值为String,所以序列化器用String类型
		template.setKeySerializer(new StringRedisSerializer());
		// value是对象，设置为Json
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		// PropertyAccessor.ALL所有元素可达(方法、域、构造器)，JsonAutoDetect.Visibility.ANY(忽略可见性)
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		return template;

	}

	/* 申明缓存管理器 */
	@Bean
	public RedisCacheManager getManager(RedisTemplate redisTemplate) {
		return new RedisCacheManager(redisTemplate);
	}
	
	/*生成键自动生成器*/
	@Bean
	public KeyGenerator getGenerator(){
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder builder=new StringBuilder();
				builder.append(target.getClass().getName());
				builder.append(method.getName());
				for(Object obj:params){
					builder.append(obj.toString());
				}
				return builder.toString();
			}
		};
	}

}
