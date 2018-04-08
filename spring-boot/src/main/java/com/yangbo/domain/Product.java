package com.yangbo.domain;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String name;
	private String desc;

	public Product() {
		super();
	}

	public Product(int id,String name,String desc) {
		super();
		this.id=id;
		this.name=name;
		this.desc=desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString(){
		return "我是"+name+",编号为"+id+","+desc;
	}
}
