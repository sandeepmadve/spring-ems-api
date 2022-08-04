package com.bk.learning.ems.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//		basePackages = "com.bk.learning.ems.repository",
//		entityManagerFactoryRef = "secondaryDataSourceEMF",
//		transactionManagerRef = "secondaryDataSourceTM"
//)
public class SecondaryDataSourceConfiguration {
	
//	//Data Source Properties
//	@Bean
//	@ConfigurationProperties(prefix = "secondary.datasource")
//	public DataSourceProperties secondaryDataSourceProperties() {
//		return new DataSourceProperties();
//	}
//	
//	//Data Source bean
//	@Bean(name = "secondaryDataSource")
//	public DataSource secondaryDataSource() {
//		return secondaryDataSourceProperties()
//				.initializeDataSourceBuilder()
//				.type(HikariDataSource.class)
//				.build();
//	}
//	
//	//Entity Manager Factory for JPA repositories
//	@Bean(name = "secondaryDataSourceEMF")
//	public LocalContainerEntityManagerFactoryBean getSecondaryDataSourceEMF(
//			EntityManagerFactoryBuilder builder,
//			@Qualifier("secondaryDataSource") DataSource dataSource) {
//		return builder
//				.dataSource(secondaryDataSource())
//				.persistenceUnit("secondaryPersistenceUnit")
//				.build();
//	}
//	
//	//Transaction Manager
//	@Bean(name = "secondaryDataSourceTM")
//	public PlatformTransactionManager secondaryDataSourceTM(
//			final @Qualifier("secondaryDataSourceEMF") LocalContainerEntityManagerFactoryBean emf) {
//		return new JpaTransactionManager(emf.getObject());
//	}
//	
}
