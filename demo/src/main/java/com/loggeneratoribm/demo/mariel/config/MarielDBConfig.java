package com.loggeneratoribm.demo.mariel.config;
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
		  basePackages = "com.loggeneratoribm.demo.mariel.repositories",
		  transactionManagerRef = "marielTransactionManager",
		  jdbcOperationsRef = "marielJdbcOperations"
		)
public class MarielDBConfig {
    @Bean(name = "marielProps")
	@ConfigurationProperties("mariel.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "marielDatasource")
	@ConfigurationProperties(prefix = "mariel.datasource")
	public DataSource datasource(@Qualifier("marielProps") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean("marielJDBC")
	public JdbcTemplate jdbcTemplate(@Qualifier("marielDatasource") DataSource ccbsDataSource) {
		return new JdbcTemplate(ccbsDataSource);
	}

	@Bean("marielTx")
	public PlatformTransactionManager platformTransactionManager(@Qualifier("marielDatasource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
