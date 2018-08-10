package com.cc.concurrency;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurationSupport{

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean httpFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(new HttpFilter());
		registrationBean.addUrlPatterns("/threadLocal/*");
		return registrationBean;
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");

	}
}


