package com.jcute.sample.define.frommethod;

import com.jcute.core.annotation.Component;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.sample.define.fromclass.TestDefineService;

/**
 * 测试通过方法定义创建对象实例
 * @author tangbin
 *
 */
@Configuration
public class TestDefineFromMethod{
	
	public static void main(String[] args){
		JCuteApplication application = JCuteApplication.run(TestDefineFromMethod.class);
		System.out.println(application.getApplicationContext().getBean(TestDefineService.class));
	}
	
	@Component
	public TestDefineService service(){
		return new TestDefineService();
	}
	
}