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
	
	//构造函数选举优先级
	//最低
	public TestAutoInvokeConstructor(String name){
		System.out.println("constructor -> " + name);
	}
	
	//参数含有@Autowited其次
	public TestAutoInvokeConstructor(@Autowired StandardUserInfoService service){
		System.out.println(service.getUserName());
	}
	
	//构造函数上还有@Initial注解最高
	@Initial
	public TestAutoInvokeConstructor(@Autowired AdministratorUserInfoService service){
		System.out.println(service);
	}
	
	@Initial
	public void initial(){
		System.out.println("initial");
	}
	
}