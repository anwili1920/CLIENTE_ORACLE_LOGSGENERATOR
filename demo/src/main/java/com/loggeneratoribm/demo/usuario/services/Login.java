package com.loggeneratoribm.demo.usuario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service; 

import com.loggeneratoribm.demo.model.tamara.CurrentUser;

@Service
public class Login {
    
    //aqui llamaré a todos los repositorios de los usuarios y tal.
    
     public String getCurrentUserDB(JdbcTemplate template) {
        String query="select USER AS USUARIO from dual";
        CurrentUser resultado= (CurrentUser) template.queryForObject(query, new BeanPropertyRowMapper(CurrentUser.class));
        return resultado.getUsuario();
    }
    
}
