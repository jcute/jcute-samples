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
@EnableShutDownHook//未设置watting，程序执行结束自动销毁
public class TestNoWattingShutDownHookPlugin{
	
	public static void main(String[] args){
		JCuteApplication.run(TestNoWattingShutDownHookPlugin.class);
	}
	
}