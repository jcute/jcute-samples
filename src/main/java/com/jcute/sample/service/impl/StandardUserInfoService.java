package com.jcute.sample.service.impl;

import java.util.Date;

import com.jcute.core.annotation.Component;
import com.jcute.sample.service.IUserInfoService;

@Component
public class StandardUserInfoService implements IUserInfoService{

	public String getUserName(){
		return "I am StandardUserInfoService";
	}

	public Date getUserBirthday(){
		return new Date();
	}
	
}