package com.battery.common.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.stereotype.Component;

import com.battery.common.utils.SerializeUtil;

@Component
@ConditionalOnBean(value= {RedisCache.class,RedisClientTemplate.class})
@AutoConfigureAfter(value= {RedisCache.class,RedisClientTemplate.class})
public class RedisCacheAgent {
	private final RedisCache redisCache;
	
	@Autowired
	public  RedisCacheAgent(RedisCache redisCache, RedisClientTemplate redisClient) {
		this.redisCache = redisCache;
		redisCache.setName("station");
		redisCache.setRedisTemplate(redisClient);
	}
	
	public void refreshCache(Object key, Object value) {
		redisCache.put(key, value);
	}
	
	/**
	 * 获取最新数据的方法
	 * @param key
	 * @return
	 */
	public byte[] getValue(Object key) {
		return redisCache.getValue(key);
	}

	
	public Object getCache(Object key){
		ValueWrapper valueWrapper = redisCache.get(key);
		if (valueWrapper != null) {
			return valueWrapper.get();
		}
		return null;
	}
	
	public void clear(String key) {
		redisCache.evict(key);
	}
}
