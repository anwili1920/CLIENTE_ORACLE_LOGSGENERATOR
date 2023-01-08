package com.loggeneratoribm.demo.config;


 
import javax.sql.DataSource;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import jakarta.persistence.EntityManagerFactory;
 

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "clienteEntityManagerFactory",
        transactionManagerRef = "clienteTransactionManager",
        basePackages = { "package com.loggeneratoribm.demo.repositories.cliente" })
public class ClienteDBConfig {
    // @Primary
    // @Bean
    // public DataSource datasource() {
    //     return DataSourceBuilder.create()
    //             .driverClassName("oracle.jdbc.OracleDriver")
    //             .url("jdbc:oracle:thin:@52.116.40.218:1521/orcl")
    //             .username("CLIENTE_DB")
    //             .password("passwd123")
    //             .build();
    // }
    @Primary
    @Bean(name = "clienteProps")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
    @Primary
    @Bean(name="clienteDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(@Qualifier("clienteProps") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }
    @Primary
    @Bean(name="clienteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,@Qualifier("clienteDatasource") DataSource dataSource){
        return builder
                .dataSource( dataSource)
                .packages("com.loggeneratoribm.demo.model.cliente")
                .persistenceUnit("orcl").build();
    }
    @Primary
    @Bean(name = "clienteTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("clienteEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    //en la parte de persistenceUnit, ambos esquemas tendrán lo mismo
}
