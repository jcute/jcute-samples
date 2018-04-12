package com.jcute.sample.service.impl;

import java.util.Date;

import com.jcute.core.annotation.Component;
import com.jcute.sample.service.IUserInfoService;

@Component
public class AdministratorUserInfoService implements IUserInfoService{

	public String getUserName(){
		return "I am AdministratorUserInfoService";
	}

	public Date getUserBirthday(){
		return new Date();
	}
	
}