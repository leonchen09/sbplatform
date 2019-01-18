package com.battery.common.redis;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.Callable;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;

import com.battery.common.utils.SerializeUtil;

@Component
@ConditionalOnBean(value=RedisClientTemplate.class)
@AutoConfigureAfter(value=RedisClientTemplate.class)
public class RedisCache implements Cache {
	private RedisClientTemplate redisTemplate;
	private String name = "";
	private Integer expireSec;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getNativeCache() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisClientTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExpireSec() {
		return expireSec;
	}

	public void setExpireSec(Integer expireSec) {
		this.expireSec = expireSec;
	}

	@Override
	public ValueWrapper get(Object key) {
		// 修改key的值，与name绑定
		String _key = String.valueOf(key);// key必须是String 类型
		ValueWrapper result = null;
		// 从redis获取数据
		byte[] v = redisTemplate.get(_key.getBytes());
		Object thevalue = SerializeUtil.unserialize(v);
		if (thevalue != null) {
			result = new SimpleValueWrapper(thevalue);
		}
		return result;
	}

	@Override
	public <T> T get(Object key, Class<T> type) {

		return null;
	}

	public <T> T get(Object key, Callable<T> valueLoader) {
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		// 修改key的值，与name绑定
		String _key = String.valueOf(key);// key必须是String 类型
		// 将数据存入redis
		if (null != value) {
			Serializable val = (Serializable) value;// value必须是Serializable类型
			redisTemplate.set(_key.getBytes(), SerializeUtil.serialize(val));
			if (expireSec != null) {
				redisTemplate.expire(_key.getBytes(), expireSec);
			}
		}
	}

	/**
	 * 获取最新数据的值
	 * @param key
	 * @return
	 */
	public byte[] getValue(Object key) {
		// 修改key的值，与name绑定
		String _key = String.valueOf(key);// key必须是String 类型
		// 将数据存入redis
		byte[] bs = redisTemplate.get(_key.getBytes());
		return bs;
	}
	
	
	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		return null;
	}

	@Override
	public void evict(Object key) {
		// 修改key的值，与name绑定
		String _key = String.valueOf(key);// key必须是String 类型
		// 从redis中删除
		redisTemplate.del(_key);
	}

	@Override
	public void clear() {
		// 清楚缓存，需要根据Cache的name属性，在redis中模糊查询相关key值的集合，并全部删除
		String pattern = this.name + "*";// 前缀匹配
		Set<String> ks = redisTemplate.keys(pattern);
		for (String sts : ks) {
			this.redisTemplate.del(sts);
		}
	}
}
