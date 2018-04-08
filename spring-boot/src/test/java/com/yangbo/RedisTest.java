package com.yangbo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangbo.domain.Product;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
public class RedisTest {
/*	@Autowired
	private RedisConnectionFactory factory;
	@Autowired
	private RedisTemplate<String, Object> template;

	@Test
	public void testRedis() {
		RedisConnection conn = factory.getConnection();
		conn.set("username".getBytes(), "zhuhongjiao".getBytes());
		System.out.println(new String(conn.get("username".getBytes())));
	}

	@Test
	public void testRedisTemplate() {
		template.opsForValue().set("username", "yangbo");
		System.out.println(template.opsForValue().get("username"));
	}

	@Test
	public void testRedisTemplateList() {
		template.opsForList().leftPush("list", "zhu");
		template.opsForList().rightPush("list", "yang");
		List<Object> list = template.opsForList().range("list", 0, template.opsForList().size("list") - 1);
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	@Test
	public void testRedisJsonTemplate() {
		template.opsForList().leftPush("product", new Product(1, "香蕉", "又黄又软"));
		template.opsForList().leftPush("product", new Product(2, "黄瓜", "女神喜欢的"));
		// Object object=template.opsForList().leftPop("product");
		// System.out.println(object);
		List<Object> list = template.opsForList().range("product", 1, template.opsForList().size("list"));
		for (Object obj : list) {
			System.out.println(obj);
		}
	}*/

}
