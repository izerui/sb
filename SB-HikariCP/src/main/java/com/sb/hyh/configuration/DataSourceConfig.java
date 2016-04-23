package com.sb.hyh.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig(
				getClass().getClassLoader().getResource("HikariCP.properties").getPath());
		return new HikariDataSource(config);
	}
}
