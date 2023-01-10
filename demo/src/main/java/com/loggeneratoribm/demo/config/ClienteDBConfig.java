package com.loggeneratoribm.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jdbc.repository.config.*;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories(
		  basePackages = "com.loggeneratoribm.demo.repositories.cliente",
		  transactionManagerRef = "clienteTransactionManager",
		  jdbcOperationsRef = "clientesJdbcOperations"
		)
public class ClienteDBConfig {
	
	@Primary
	@Bean(name = "clienteProps")
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "clienteDatasource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource datasource(@Qualifier("clienteProps") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean("clienteJDBC")
	public JdbcTemplate jdbcTemplate(@Qualifier("clienteDatasource") DataSource ccbsDataSource) {
		return new JdbcTemplate(ccbsDataSource);
	}

	@Bean("clienteTx")
	public PlatformTransactionManager platformTransactionManager(@Qualifier("clienteDatasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
