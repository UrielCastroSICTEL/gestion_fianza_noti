package com.sictel.gestion.fianza.consola.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.sictel.gestion.fianza.business.repository")
@ComponentScan(basePackages = { "com.sictel.gestion.fianza.business.service",
		"com.sictel.gestion.fianza.business.repository" })
@PropertySource("classpath:config_gestion_fianza_noti_con.properties")
public class ConfigSpringDataJpa {

	@Value("${hibernate.pakage.scan}")
	String hibernate_pakage_scan;

	@Value("${jdbc.driver.class.name}")
	String jdbc_driver_class_name;
	@Value("${jdbc.url}")
	String jdbc_url;
	@Value("${jdbc.username}")
	String jdbc_username;
	@Value("${jdbc.password}")
	String jdbc_password;

	@Value("${hibernate.dialect}")
	String hibernate_dialect;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(jdbc_driver_class_name);
		dataSource.setUrl(jdbc_url);
		dataSource.setUsername(jdbc_username);
		dataSource.setPassword(jdbc_password);
		dataSource.setConnectionProperties(additionalProperties());

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(hibernate_pakage_scan);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("connection.pool_size", "10");

		return properties;
	}

}
