package com.loggeneratoribm.demo.hacker.repositories;

import org.springframework.data.domain.jaxb.SortAdapter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.config.NewSession;
import com.loggeneratoribm.demo.hacker.dao.HackerDAO;
import com.loggeneratoribm.demo.model.database.DBConfig;
import com.loggeneratoribm.demo.services.Login;
@Service
public class HackerImpl implements HackerDAO{
   
    @Override
    public Integer forcebruteloggin(DBConfig user) {
        NewSession intento=new NewSession();
        JdbcTemplate jdbcTemplate;
        String contraintento= user.getPassword();
        Integer contar=0;
        boolean i=true;
        Login loggeo = new Login();
        while(i){
                contar++;
                user.setPassword(contraintento+contar);
                intento.setDBConfig(user);
                jdbcTemplate=intento.getCustomJdbcTemplate();
                loggeo.setTemplate(jdbcTemplate);
            try{
                loggeo.getCurrentUserDBName();
                i=false;
            }catch(Exception e){
                System.out.println("-----------------------------------------------");
                System.out.println("La contraseña "+ user.getPassword()+" es incorrecta");
                System.out.println("-----------------------------------------------");
            } 
        }
        
        return contar;
    }
    
}
