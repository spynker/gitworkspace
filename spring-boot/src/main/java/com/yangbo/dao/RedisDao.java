package com.yangbo.dao;

import org.springframework.stereotype.Service;

import com.yangbo.domain.Product;

@Service
public class RedisDao {
	public Product getPrud(int id){
		return new Product(id,"name_"+id,"desc_"+id);
	}
}
