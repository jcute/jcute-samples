package com.jcute.sample.define.fromclass;

import com.jcute.core.annotation.Autowired;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Initial;
import com.jcute.core.boot.JCuteApplication;

/**
 * 测试扫描类以构造函数方式实例化对象
 * @author tangbin
 *
 */
@Configuration
public class TestDefineFromClass{
	
	@Autowired
	private TestDefineService service;
	
	public static void main(String[] args){
		JCuteApplication.run(TestDefineFromClass.class);
	}
	
	@Initial
	public void initial(){
		System.out.println(this.service);
	}
	
}