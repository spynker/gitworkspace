package com.yangbo.mapper;

import java.util.List;

import com.yangbo.entity.UserEntity;

public interface UserMapper {
	UserEntity getOne(Long id);

	List<UserEntity> getAll();

	void delete(Long id);

	void save(UserEntity user);

	void update(UserEntity user);
}
