package com.jcute.sample.scope;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.boot.JCuteApplication;

@Configuration
public class TestScope{
	
	public static void main(String[] args){
		JCuteApplication application = JCuteApplication.run(TestScope.class);
		TestScopeServiceA serviceA_1 = application.getApplicationContext().getBean(TestScopeServiceA.class);
		TestScopeServiceA serviceA_2 = application.getApplicationContext().getBean(TestScopeServiceA.class);
		
		//因为是单例，所以结果为true
		System.out.println(serviceA_1.equals(serviceA_2));
		
		//因为是多例，所以结果为false
		TestScopeServiceB serviceB_1 = application.getApplicationContext().getBean(TestScopeServiceB.class);
		TestScopeServiceB serviceB_2 = application.getApplicationContext().getBean(TestScopeServiceB.class);
		System.out.println(serviceB_1.equals(serviceB_2));
		
	}
	
	
	
}