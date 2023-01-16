package com.loggeneratoribm.demo.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.model.DBConfig;
import com.loggeneratoribm.demo.model.User;
import com.loggeneratoribm.demo.usuario.dao.LoginDAO;

@RestController
public class LoginController {
    @Autowired
    private LoginDAO loginDAO;
    @GetMapping("/iniciarSesionUsuario") 
    public String setNewSession(@RequestBody DBConfig usuario) {  
        System.out.println("2");
        return loginDAO.beginSession(usuario);
    }
     
}
