package com.jcute.sample.plugin.cache;

import com.jcute.core.annotation.Autowired;
import com.jcute.core.annotation.Configuration;
import com.jcute.core.annotation.Initial;
import com.jcute.core.boot.JCuteApplication;
import com.jcute.plugin.cache.EnableCacheManager;

/**
 * 使用@EnableCacheManager标注启用CacheManager注解<br/>
 * 启用cacheManager属性是标注所使用的cacheManager名称，<br/>
 * 如果默认不设置，系统会自动创建DefaultCacheManager作为cache管理器。<br/>
 * 如果需要自定义可添加自定义的cacheManager实现<br/>
 * 
 * @author tangbin
 *
 */
@Configuration
@EnableCacheManager // 启用注解
public class TestDefaultCacheManager{

	public static void main(String[] args){
		JCuteApplication.run(TestDefaultCacheManager.class);
	}

	@Initial
	public void initial(@Autowired TestCacheService service){
		long a = System.currentTimeMillis();
		for(int i = 0;i < 15;i++){
			System.out.println("v:" + service.getCount());
			if(i == 5){
				service.evictGetCountMethodCache();
			}
			if(i == 10){
				service.clearCache();
			}
		}
		System.out.println(System.currentTimeMillis() - a);
	}

}