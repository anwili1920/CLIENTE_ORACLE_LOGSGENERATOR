package com.loggeneratoribm.demo.config;

 
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "tamaraEntityManagerFactory",
        transactionManagerRef = "tamaraTransactionManager",
        basePackages = { "package com.loggeneratoribm.demo.repositories.tamara" })
public class TamaraDBConfig {
    // @Bean
    // public DataSource tamaraDatasource() {
    //     return DataSourceBuilder.create()
    //             .driverClassName("oracle.jdbc.OracleDriver")
    //             .url("jdbc:oracle:thin:@52.116.40.218:1521/orcl")
    //             .username("TAMARA")
    //             .password("passwd123")
    //             .build();
    // }
    @Bean(name = "tamaraProps")
    @ConfigurationProperties("tamara.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    } 
    @Bean(name="tamaraDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(@Qualifier("tamaraProps") DataSourceProperties properties){
        return  properties.initializeDataSourceBuilder().build();
    }
    @Bean(name="tamaraEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,@Qualifier("tamaraDatasource") DataSource dataSource){
        return builder
                .dataSource(  dataSource)
                .packages("com.loggeneratoribm.demo.model.tamara")
                .persistenceUnit("orcl").build();
    } 
    @Bean(name = "tamaraTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("tamaraEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    //en la parte de persistenceUnit, ambos esquemas tendrán lo mismo
}
