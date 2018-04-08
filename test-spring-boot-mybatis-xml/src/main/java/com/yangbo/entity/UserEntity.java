package com.yangbo.entity;

import java.io.Serializable;

import com.yangbo.Enum.UserSex;

public class UserEntity implements Serializable{
	private static final long serialVersionUID=1L;
	
	private Long id;
	private String userName;
	private String passWord;
	private UserSex userSex;
	private String nickName;
	
	public UserEntity(){
		super();
	}
	
	public UserEntity(String userName,String passWord,UserSex userSex,String nickName){
		super();
		this.userName=userName;
		this.passWord=passWord;
		this.userSex=userSex;
		this.nickName=nickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserSex getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSex userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "姓名:"+userName+",性别:"+userSex+",昵称:"+nickName;
	}
	
	
}
