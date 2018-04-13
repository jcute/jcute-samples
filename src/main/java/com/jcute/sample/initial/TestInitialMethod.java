package com.jcute.sample.initial;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Initial;
import com.jcute.core.annotation.Order;
import com.jcute.core.boot.JCuteApplication;

/**
 * 此类测试初始化方法及初始化方法执行顺序
 * 
 * @author tangbin
 *
 */
@Configuration
public class TestInitialMethod{

	public static void main(String[] args){
		JCuteApplication.run(TestInitialMethod.class);
	}

	@Initial
	@Order(2)
	public void initialA(){
		System.out.println("我是其次执行");
	}

	@Initial
	@Order(1)
	public void initialB(){
		System.out.println("我是首先执行");
	}

}