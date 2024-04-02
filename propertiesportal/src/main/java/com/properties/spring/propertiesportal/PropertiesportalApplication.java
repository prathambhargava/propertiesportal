package com.properties.spring.propertiesportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class PropertiesportalApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertiesportalApplication.class, args);
	}
}
