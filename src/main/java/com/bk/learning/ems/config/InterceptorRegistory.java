package com.bk.learning.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorRegistory implements WebMvcConfigurer {
	
	@Autowired
	private IPAddressInterceptor ipAddressInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ipAddressInterceptor);
	}
}
