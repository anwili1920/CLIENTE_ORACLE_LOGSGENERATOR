package com.loggeneratoribm.demo.tamara.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories(
		  basePackages = "com.loggeneratoribm.demo.tamara.repositories",
		  transactionManagerRef = "tamaraTransactionManager",
		  jdbcOperationsRef = "clientesJdbcOperations"
		)
public class TamaraDBConfig {

	@Bean(name = "tamaraProps")
	@ConfigurationProperties("tamara.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "tamaraDatasource")
	@ConfigurationProperties(prefix = "tamara.datasource")
	public DataSource datasource(@Qualifier("tamaraProps") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean("tamaraJDBC")
	public JdbcTemplate jdbcTemplate(@Qualifier("tamaraDatasource") DataSource ccbsDataSource) {
		return new JdbcTemplate(ccbsDataSource);
	}

	@Bean("tamaraTx")
	public PlatformTransactionManager platformTransactionManager(@Qualifier("tamaraDatasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
