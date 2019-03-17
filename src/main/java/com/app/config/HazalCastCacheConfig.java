package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Configuration
public class HazalCastCacheConfig {

	@Bean
	public Config cacheConfig() {

		return new Config().setInstanceName("hazal-instance")
				.addMapConfig(

						new MapConfig()
						.setName("products-cache")
						.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU)
						.setTimeToLiveSeconds(20000)
						);
	}
}
