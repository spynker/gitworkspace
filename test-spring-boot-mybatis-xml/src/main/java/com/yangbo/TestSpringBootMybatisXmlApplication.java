package com.yangbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yangbo.mapper")
public class TestSpringBootMybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootMybatisXmlApplication.class, args);
	}
}
