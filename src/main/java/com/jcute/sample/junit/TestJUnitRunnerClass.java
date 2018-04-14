package com.jcute.sample.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.jcute.core.annotation.Autowired;
import com.jcute.core.annotation.ComponentScan;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.ImportConfig;
import com.jcute.core.annotation.Property;
import com.jcute.core.junit.JCuteJUnitForClassRunner;
import com.jcute.sample.service.impl.StandardUserInfoService;

/**
 * 测试JUnit runner
 * 
 * @author tangbin
 *
 */
@RunWith(JCuteJUnitForClassRunner.class)
@Configuration(configs = @ImportConfig("server.properties"))
@ComponentScan("com.jcute.sample.service.impl")
public class TestJUnitRunnerClass{
	
	@Property("server.name")
	private String serverName;
	
	@Autowired
	private StandardUserInfoService service;

	@Test
	public void testRun(){
		System.out.println(this.serverName);
		System.out.println(this.service.getUserName());
	}

}