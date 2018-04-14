package com.jcute.sample.define.frominstance;

import com.jcute.core.annotation.Autowired;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Initial;
import com.jcute.core.bean.BeanFactory;
import com.jcute.core.bean.imp.BeanDefinitionByInstance;
import com.jcute.core.context.ApplicationContext;
import com.jcute.core.context.imp.ApplicationContextByAnnotation;
import com.jcute.sample.define.fromclass.TestDefineService;

@Configuration
public class TestDefineFromInstance{

	public static void main(String[] args) throws Exception{

		// 此处无法直接使用JCuteApplication.run
		// BeanFactory在调用addBeanDefinition必须保证application的initial方法没有调用
		// 也就是说addBeanDefinition必须在application context初始化之前执行
		// 因此JCuteApplication会自动调用初始化，所以无法使用JCuteApplication
		// 如果必须要使用此方法创建Bean定义请使用插件机制完成
		ApplicationContext applicationContext = new ApplicationContextByAnnotation(TestDefineFromInstance.class);
		BeanFactory beanFactory = applicationContext.getBeanFactory();
		TestDefineService service = new TestDefineService();
		beanFactory.addBeanDefinition(new BeanDefinitionByInstance(beanFactory,service.getClass(),null,null,service));
		applicationContext.initial();

		applicationContext.destory();

	}

	@Autowired
	private TestDefineService service;

	@Initial
	public void initial(){
		System.out.println(this.service);
	}

}