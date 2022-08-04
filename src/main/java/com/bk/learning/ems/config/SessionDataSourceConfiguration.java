package com.bk.learning.ems.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class SessionDataSourceConfiguration {
	
	/**
	 * data source properties
	 */
	@Bean
	@ConfigurationProperties("session.datasource")
	public DataSourceProperties sessionDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	/**
	 * datasource
	 * @return
	 */
	@Bean(name = "sessionDatasource")
	@SpringSessionDataSource
	public DataSource sessionDataSource() {
		return sessionDataSourceProperties()
				.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
	
	
	/**
	 * For H2 db as session db
	 */
//	@Bean
//	@SpringSessionDataSource
//	public EmbeddedDatabase springSessionDataSource() {
//		return new EmbeddedDatabaseBuilder()
//				.setType(EmbeddedDatabaseType.H2)
//				.addScript("org/springframework/session/jdbc/schema-h2.sql")
//				.build();
//	}
	
}
