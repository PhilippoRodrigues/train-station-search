package com.philippo.trainstation.config;

import com.philippo.trainstation.api.controller.StationController;
import com.philippo.trainstation.domain.model.Station;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.cache.Caching;
import java.util.Objects;

@Configuration
@EnableCaching
@EnableAsync
@ComponentScan(basePackageClasses={ CacheConfig.class, CacheEventLogger.class})
public class CacheConfig implements WebMvcConfigurer {

    @Bean
    public CacheManager cacheManager ()
        throws Exception {
        return new JCacheCacheManager(
            Caching.getCachingProvider()
            .getCacheManager(
                Objects
                    .requireNonNull(getClass().getResource("/env/ehcache.xml"))
                    .toURI(),
                getClass().getClassLoader()));
    }
}
