package com.pos.configurations;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfiguration {

	@Bean
	public DataSource dataSource() {
		var data = DataSourceBuilder.create();
		
		data.driverClassName("org.h2.Driver");
		data.url("jdbc:h2:mem:testDb");
		data.username("SA");
		data.password("");
		
		return data.build();
	}
	
	@Bean
	public ModelMapper getModel() {
		return new ModelMapper();
	}
	
}
