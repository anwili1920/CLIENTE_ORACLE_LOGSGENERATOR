package com.loggeneratoribm.demo.services;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.model.backend.CurrentUser;

@Service
public class Login {
    
    //aqui llamaré a todos los repositorios de los usuarios y tal.
    private CurrentUser currentUser;
    private JdbcTemplate template;

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }
    
    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public String getCurrentUserDBName() {
        String query="select USER AS USUARIO from dual";
        CurrentUser resultado= (CurrentUser) template.queryForObject(query, new BeanPropertyRowMapper(CurrentUser.class));
        setCurrentUser(resultado);
        return resultado.getUsuario();
    }
    
}
