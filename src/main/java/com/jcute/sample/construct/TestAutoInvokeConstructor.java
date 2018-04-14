package com.jcute.sample.construct;

import com.jcute.core.annotation.Autowired;
import com.jcute.core.annotation.ComponentScan;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Initial;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.sample.service.impl.AdministratorUserInfoService;
import com.jcute.sample.service.impl.StandardUserInfoService;

/**
 * 测试自定义构造函数实例化
 * @author tangbin
 *
 */
@Configuration
@ComponentScan("com.jcute.sample.service.impl")
public class TestAutoInvokeConstructor{
	
	public static void main(String[] args){
		JCuteApplication application = JCuteApplication.run(TestAutoInvokeConstructor.class);
		TestAutoInvokeConstructor con = application.getApplicationContext().getBean(TestAutoInvokeConstructor.class);
		System.out.println(con);
	}
	
	public TestAutoInvokeConstructor(String name){
		System.out.println("constructor -> " + name);
	}
	
	public TestAutoInvokeConstructor(@Autowired StandardUserInfoService service){
		System.out.println(service.getUserName());
	}
	
	@Initial
	public TestAutoInvokeConstructor(@Autowired AdministratorUserInfoService service){
		System.out.println(service);
	}
	
	@Initial
	public void initial(){
		System.out.println("initial");
	}
	
}