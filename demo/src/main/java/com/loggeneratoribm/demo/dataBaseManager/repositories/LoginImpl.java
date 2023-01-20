package com.loggeneratoribm.demo.dataBaseManager.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.config.NewSession;
import com.loggeneratoribm.demo.dataBaseManager.dao.LoginDAO;
import com.loggeneratoribm.demo.model.database.DBConfig;
import com.loggeneratoribm.demo.services.Login; 


@Repository
public class LoginImpl implements LoginDAO {
    @Autowired
    NewSession nuevaSesion;
    @Autowired
    Login login;
    public Login getLogin() {
        return login;
    }
    @Override
    public NewSession beginSession(DBConfig dbConfig) { 
        System.out.println("nuevaSesion: " + nuevaSesion);
        nuevaSesion.setDBConfig(dbConfig);
        JdbcTemplate jdbcTemplate = nuevaSesion.getCustomJdbcTemplate();
        login.setTemplate(jdbcTemplate);
        return  nuevaSesion;
    
    }

     
    
}
