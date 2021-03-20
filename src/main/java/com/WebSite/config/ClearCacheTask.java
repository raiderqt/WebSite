package com.WebSite.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Component;
@Configuration
@EnableCaching
@Component
public class ClearCacheTask {
    @Autowired
    CacheManager cacheManager;
    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }



    public void evictSingleCacheValue(String cacheName, String cacheKey) {
        cacheManager.getCache(cacheName).evict(cacheKey);
    }

    public void evictAllCacheValues(String cacheName) {
        cacheManager.getCacheNames().clear();
    }

}