package com.yangbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yangbo.dao.RedisDao;
import com.yangbo.domain.Product;

@RestController
public class RedisController {
	
	@Autowired
	private RedisDao productDao;
	
	@RequestMapping("/getPrud")
	@Cacheable(value="PrudCache")
	public Product getPrud(@RequestParam(value="id",required=true) String id){
		System.out.println("如果缓存第二次没有走到这里说明调用了缓存");
		return productDao.getPrud(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/getPrud2")
	@CachePut(value="PrudCache",key="#result.id +''")
	public Product getPrud2(@RequestParam(value="id",required=true)String id){
		System.out.println("CachePut");
		return productDao.getPrud(Integer.parseInt(id));
	}
	
	@RequestMapping("/deletePrud")
	@CacheEvict(value="Prudcache")
	public String deletePrud(@RequestParam(value="id",required=false)String id){
		System.out.println("deletePrud");
		return "Success";
	}
	
	@RequestMapping("/getPrud3")
    @Cacheable(value ="prudCache",key="#root.targetClass.getName() + #root.methodName + #id")
    public Product getPrud3(@RequestParam(required=true)String id){
        System.out.println("如果第二次没有走到这里说明缓存被添加了");
        return productDao.getPrud(Integer.parseInt(id));
    }
}
