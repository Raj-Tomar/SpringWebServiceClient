package com.raj.project.configuration;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectConfiguration implements InitializingBean {

	@Autowired
	Properties properties;

	public static Logger logger = Logger.getLogger(ProjectConfiguration.class);
	
	public static String serviceUrl;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		final String currentEnviroment = properties.getProperty("projecct.environment").trim();
		logger.info("Current Environment: "+currentEnviroment);
		if("development".equalsIgnoreCase(currentEnviroment)){
			configDevelopment();
		}
		else if("production".equalsIgnoreCase(currentEnviroment)){
			configProduction();
		}
	}

	private void configProduction() {
		logger.info("Development Environment Configuration Start\n");
		serviceUrl = properties.getProperty("com.raj.developement").trim();
	}

	private void configDevelopment() {
		logger.info("Development Environment Configuration Start\n");
		serviceUrl = properties.getProperty("com.raj.production").trim();
	}
}