package com.loggeneratoribm.demo.config;

 

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.model.database.DBConfig; 

@Service
public class NewSession {
    private DBConfig dbSettings;

    public void setDBConfig(DBConfig dbSettings) {
        this.dbSettings = dbSettings;
    }

    public DataSource getCustomDataSource() {
        DataSourceBuilder dsBuilder = DataSourceBuilder.create();
        dsBuilder.driverClassName(dbSettings.getDriverClass());
        dsBuilder.url(dbSettings.getDriverURL() + dbSettings.getSchema());
        dsBuilder.username(dbSettings.getUsername());
        dsBuilder.password(dbSettings.getPassword());
        return dsBuilder.build();
    }
    public JdbcTemplate getCustomJdbcTemplate() {
        return new JdbcTemplate(getCustomDataSource());
    }
}
