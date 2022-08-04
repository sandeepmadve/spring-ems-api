package com.bk.learning.ems.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.bk.learning.ems.repository",
		entityManagerFactoryRef = "primaryDatasourceEMF",
		transactionManagerRef = "primaryDatasourceTM"
)
public class PrimaryDataSourceConfiguration {
	
	/**
	 * Primary Data Source properties
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "primary.datasource")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	/**
	 * Primary Data Source
	 */
	@Primary
	@Bean(name = "primaryDatasource")
	public DataSource primaryDataSource() {
		
		return primaryDataSourceProperties()
				.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
		
	}
	
	/**
	 * Primary Entity Manager Factory
	 */
	@Primary
	@Bean(name = "primaryDatasourceEMF")
	public LocalContainerEntityManagerFactoryBean primaryDatasourceEMF(
			EntityManagerFactoryBuilder builder, 
			@Qualifier("primaryDatasource") DataSource dataSource) {
		
		return builder
				.dataSource(dataSource)
				.packages("com.bk.learning.ems.entity")
				.persistenceUnit("primaryPersistenceUnit")
				.build();
				
	}
	
	
	/**
	 * Transaction Manager for primary datasource. Can be used as @Transaction("primary-datasource-tm")
	 */
	@Primary
	@Bean(name = "primaryDatasourceTM")
	public PlatformTransactionManager primaryDatasourceTM(
			@Qualifier("primaryDatasourceEMF") LocalContainerEntityManagerFactoryBean emf) {
		
		return new JpaTransactionManager(emf.getObject());
		
	}
	
}
