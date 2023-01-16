package com.loggeneratoribm.demo.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.cliente.dao.DataManagerDAO;
import com.loggeneratoribm.demo.model.User;
import com.loggeneratoribm.demo.model.cliente.DBConnection;
import com.loggeneratoribm.demo.model.cliente.DBProcedure;
import com.loggeneratoribm.demo.model.cliente.DBUser;

@RestController
public class DataManagerController{

    @Autowired
    private DataManagerDAO dataManagerDAO;
    
    @GetMapping("/dbusuarios") 
    public List<DBUser> getDBUSERS() {  
        return dataManagerDAO.listALLDBUsers();
    }
    @GetMapping("/dbconexiones")
    public List<DBConnection> getConnections(){
        return dataManagerDAO.ListALLConnections();
    }
    @GetMapping("/dbproceduresxschema/{schemaName}")
	public List<DBProcedure> getProcedures(@PathVariable String schemaName) {
		return dataManagerDAO.ListALLSchemaProcedure(schemaName);
	}
    @PostMapping("/dbnuevoUsuario")
    public String setNewUser(@RequestBody User usuarionuevo){
        return dataManagerDAO.CreateUser( usuarionuevo.getUsername(),usuarionuevo.getPassword());
    }

}
