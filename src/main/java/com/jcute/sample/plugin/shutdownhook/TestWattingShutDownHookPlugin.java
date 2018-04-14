package com.jcute.sample.plugin.shutdownhook;

import com.jcute.core.annotation.Configuration;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.plugin.shutdown.EnableShutDownHook;

/**
 * 测试友好关闭的钩子插件
 * @author tangbin
 *
 */
@Configuration
@EnableShutDownHook(true)//设置watting，程序等待外部结束
public class TestWattingShutDownHookPlugin{
	
	public static void main(String[] args){
		JCuteApplication.run(TestWattingShutDownHookPlugin.class);
	}
	
}