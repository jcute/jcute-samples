package com.jcute.sample.plugin.cache;

import com.jcute.core.annotation.Component;
import com.jcute.plugin.cache.CacheClear;
import com.jcute.plugin.cache.CacheEvict;
import com.jcute.plugin.cache.CachePut;
import com.jcute.plugin.cache.Cacheable;

@Component
@Cacheable(cacheName = "test") // 指定缓存名称
public class TestCacheService{

	private int invokeCount;

	// cacheKey可以使用指定的字符串或动态获取，
	// 如果使用字符串请加上双引号@CachePut(cacheKey="'getCount'")
	// 此处cacheKey中默认存在内置变量
	// targetClass -> 当前method所在的class对象
	// targetMethod -> 当前method对象
	// targetArguments -> 当前method的参数对象
	// 可直接使用字符串格式读取这些变量，例：
	// @CachePut(cacheKey="targetMethod.getName() + targetArguments[0].toString()")
	// 如果以上参数无法满足需求，也可自定义名称，例：
	// 在方法参数中添加@CacheKey注解定义参数名称
	// @CachePut(cacheKey="name")
	// public int getCount(@CacheKey("name") String name){}
	@CachePut(cacheKey = "'getCount'")
	public int getCount(){
		return ++invokeCount;// 此处故意使用count计次，如果返回的是缓存数据，则count保持不变
	}

	@CacheEvict(cacheKey = "'getCount'") // 清除指定cacheKey的缓存
	public void evictGetCountMethodCache(){
		
	}

	@CacheClear // 清除当前Cache对象的全部缓存
	public void clearCache(){

	}

}