package com.jcute.sample.config;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.ImportConfig;
import com.jcute.core.annotation.Initial;
import com.jcute.core.annotation.Property;
import com.jcute.core.boot.JCuteApplication;

/**
 * 测试自动注入属性
 * 
 * @author tangbin
 *
 */
@Configuration(configs = {@ImportConfig("server.properties")})
public class TestConfigAutowired{
	
	//冒号前为名称，冒号后为默认值，默认值无需添加双引号
	
	@Property("server.name:localhost")
	private String serverName;
	
	@Property("server.port:8888")
	private int serverPort;
	
	@Property("server.timeout")
	private long serverTimeout;
	
	@Property("server.shutdown_hook:true")
	private boolean serverShutDownHook;
	
	@Initial
	public void initial() {
		System.out.println(this.serverName);
		System.out.println(this.serverPort);
		System.out.println(this.serverTimeout);
		System.out.println(this.serverShutDownHook);
	}
	
	public static void main(String[] args){
		JCuteApplication.run(TestConfigAutowired.class);
	}
	
}