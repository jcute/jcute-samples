package com.jcute.sample.plugin.custom;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.boot.JCuteApplication;

/**
 * 使用自定义插件机制
 * @author tangbin
 *
 */
@Configuration
@EnableCustome
public class TestCustomPlugin{
	
	public static void main(String[] args){
		JCuteApplication.run(TestCustomPlugin.class);
	}
	
}