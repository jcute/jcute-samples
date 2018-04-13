package com.jcute.sample.service;

import com.jcute.core.annotation.Autowired;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Destory;
import com.jcute.core.annotation.Initial;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.sample.service.impl.AdministratorUserInfoService;
import com.jcute.sample.service.impl.StandardUserInfoService;

@Configuration
public class BootStrapService{

	// 此处使用接口类型注入，且接口类型存在多个实例，因此需要指定实例名称
	@Autowired("standardUserInfoService")
	private IUserInfoService usA;
	// 以下使用实现类直接注入，无需指定名称
	@Autowired
	private AdministratorUserInfoService usB;
	@Autowired
	private StandardUserInfoService usC;

	@Initial
	private void initial(){
		System.out.println(this.usA.getUserName());
		System.out.println(this.usB.getUserName());
		System.out.println(this.usC.getUserName());
	}
	
	@Destory
	public void destory() {
		this.usA = null;
		this.usB = null;
		this.usC = null;
	}
	
	public static void main(String[] args){
		JCuteApplication.run(BootStrapService.class);
	}

}