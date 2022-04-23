package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author mw
 * @version JDK 8
 * @className CorsConfig
 * @date 2022/4/21 20:17
 */
@Configuration
public class CorsConfig {
	public CorsConfig() {

	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://localhost:8080");
		// 设置是否发送cookie
		config.setAllowCredentials(true);
		// 设置允许的请求方式
		config.addAllowedMethod("*");
		// 设置允许的header
		config.addAllowedHeader("*");
		// 为url添加映射路径
		UrlBasedCorsConfigurationSource crosSource = new UrlBasedCorsConfigurationSource();
		crosSource.registerCorsConfiguration("/**", config);
		// 返回重新定义的corsSource
		return new CorsFilter(crosSource);
	}
}
