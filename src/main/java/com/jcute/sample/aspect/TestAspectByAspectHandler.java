package com.jcute.sample.aspect;

import java.lang.reflect.Method;

import com.jcute.core.annotation.Component;
import com.jcute.core.annotation.ComponentScan;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Interceptor;
import com.jcute.core.aspect.AspectHandler;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.sample.service.impl.StandardUserInfoService;

/**
 * 简洁的面向切面功能测试，需继承AspectHandler类，添加@Interceptor注解，重写AspectHandler相关方法
 * 
 * @author tangbin
 *
 */
@Configuration
@Interceptor(annotations = Component.class) // 拦截所有标注Component注解的组件，拦截器无法拦截当前类实例
@ComponentScan("com.jcute.sample.service.impl")
public class TestAspectByAspectHandler extends AspectHandler{
	
	public static void main(String[] args){
		JCuteApplication application = JCuteApplication.run(TestAspectByAspectHandler.class);
		StandardUserInfoService service = application.getApplicationContext().getBean(StandardUserInfoService.class);
		service.getUserName();
	}
	
	@Override
	public boolean onIntercept(Class<?> targetClass,Method targetMethod,Object[] arguments) throws Throwable{
		System.out.println("方法拦截过滤，是否需要拦截当前方法");
		return true;
	}

	@Override
	public void onBefore(Class<?> targetClass,Method targetMethod,Object[] arguments) throws Throwable{
		System.out.println("方法调用之前");
	}

	@Override
	public void onAfter(Class<?> targetClass,Method targetMethod,Object[] arguments,Object result) throws Throwable{
		System.out.println("方法调用之后");
	}

	@Override
	public void onException(Class<?> targetClass,Method targetMethod,Object[] arguments,Throwable exception){
		System.out.println("方法调用出现异常");
	}

	@Override
	public void onBegin(){
		System.out.println("方法开始");
	}

	@Override
	public void onEnd(){
		System.out.println("方法结束");
	}

}