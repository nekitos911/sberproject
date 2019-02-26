package com.task.sberproject.config;

import com.sap.hcp.cf.logging.servlet.filter.RequestLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class ConfigLogging {

	@SuppressWarnings("static-method")
	@Bean
	public Filter requestLoggingFilter() {
		return new RequestLoggingFilter();
	}
}