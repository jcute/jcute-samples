package com.jcute.sample.boot;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.boot.JCuteApplication;

/**
 * 测试快捷启动
 * @author tangbin
 *
 */
@Configuration
public class TestBootStrap{
	
	public static void main(String[] args){
		JCuteApplication.run(TestBootStrap.class);
	}
	
}