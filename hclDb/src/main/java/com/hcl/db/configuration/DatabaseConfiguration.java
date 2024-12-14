package com.hcl.db.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {

	@Value("${hcldb.datasource.driverClassName}")
	private String driver;

	@Value("${hcldb.datasource.url}")
	private String url;

	@Value("${hcldb.datasource.username}")
	private String username;

	@Value("${hcldb.datasource.password}")
	private String password;

	@Bean("dmds")
	@Primary
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(driver);
		dmds.setUrl(url);
		dmds.setUsername(username);
		dmds.setPassword(password);
		return dmds;
	}
}
