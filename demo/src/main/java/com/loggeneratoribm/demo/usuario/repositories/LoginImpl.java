package com.loggeneratoribm.demo.usuario.repositories;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.model.DBConfig;
import com.loggeneratoribm.demo.model.User; 
import com.loggeneratoribm.demo.usuario.config.NewSession;
import com.loggeneratoribm.demo.usuario.dao.LoginDAO;
import com.loggeneratoribm.demo.usuario.services.Login; 


@Repository
public class LoginImpl implements LoginDAO {
    @Autowired
    NewSession nuevaSesion;
    
    @Autowired
    Login login;

    @Override
    public String beginSession(DBConfig dbConfig) { 
        System.out.println("nuevaSesion: " + nuevaSesion);
        nuevaSesion.setDBConfig(dbConfig);
        JdbcTemplate jdbcTemplate = nuevaSesion.getCustomJdbcTemplate();
        String current_user = login.getCurrentUserDB(jdbcTemplate);
        return "Iniciaste sesion con el usuario " + current_user;
    }
     
    
}
