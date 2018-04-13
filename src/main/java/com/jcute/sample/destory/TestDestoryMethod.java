package com.jcute.sample.destory;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Destory;
import com.jcute.core.annotation.Order;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.core.error.ContextDestoryException;

/**
 * 此类测试销毁方法及销毁方法执行顺序
 * 
 * @author tangbin
 *
 */
@Configuration
public class TestDestoryMethod{

	public static void main(String[] args) throws ContextDestoryException{
		JCuteApplication jCuteApplication = JCuteApplication.run(TestDestoryMethod.class);
		jCuteApplication.getApplicationContext().destory();
	}

	@Destory
	@Order(2)
	public void destoryA(){
		System.out.println("我是其次执行");
	}

	@Destory
	@Order(1)
	public void destoryB(){
		System.out.println("我是首先执行");
	}

}