package com.loggeneratoribm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 import com.loggeneratoribm.demo.DAO.dataManagerDAO; 
import com.loggeneratoribm.demo.model.DBUser;

@RestController
public class dataManagerController{

    @Autowired
    private dataManagerDAO queries;
    
    @GetMapping("/dbusuarios") 
    public List<DBUser> getDBUSERS() {  
        return queries.ListALLDBUsers();
    }

}
