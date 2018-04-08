package com.yangbo.Enum;

public enum UserSex {
	MAN("man"),WOMAN("woman");
	private String sex;
	private UserSex(String sex){
		this.sex=sex;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
