package com.pos.configurations;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfiguration {

	@Bean
	public DataSource dataSource() {
		DataSourceBuilder data = DataSourceBuilder.create();
		
		data.driverClassName("org.h2.Driver");
		data.url("jdbc:h2:mem:testDb");
		data.username("SA");
		data.password("");
		
		return data.build();
	}
	
}
