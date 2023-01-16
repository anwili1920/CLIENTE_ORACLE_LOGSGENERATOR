package com.loggeneratoribm.demo.mariel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.mariel.dao.DBAdminDAO;
import com.loggeneratoribm.demo.model.NameTable;
import com.loggeneratoribm.demo.model.PairUser;
import com.loggeneratoribm.demo.model.mariel.NameRequest;


@RestController
public class DBAdminController {
    @Autowired
    private DBAdminDAO dbAdminDAO;
    @GetMapping("/listadotablas") 
    public List<NameTable> getTablas(@RequestBody NameRequest duenho) {  
        return dbAdminDAO.listarTablas(duenho);
    }
    @GetMapping("/grantselect") 
    public List<String> setGrantSelect(@RequestBody PairUser par ) {  
        return dbAdminDAO.selectGrantFROMSchema(par);
    }
}
