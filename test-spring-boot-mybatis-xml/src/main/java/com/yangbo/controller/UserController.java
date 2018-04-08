package com.yangbo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yangbo.Enum.UserSex;
import com.yangbo.entity.UserEntity;
import com.yangbo.mapper.UserMapper;

@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getOne")
	public UserEntity getOne(Long id) {
		UserEntity user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping("/getAll")
	public List<UserEntity> getAll() {
		List<UserEntity> userList = userMapper.getAll();
		return userList;
	}

	@RequestMapping(value="/delete")
	public void delete(Long id) {
		userMapper.delete(id);
	}

	@RequestMapping("/save")
	public void save(UserEntity user) {
		userMapper.save(user);
	}

	@RequestMapping("/update")
	public void update(UserEntity user) {
		userMapper.update(user);
	}
}
