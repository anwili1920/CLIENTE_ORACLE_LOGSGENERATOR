package com.loggeneratoribm.demo.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.DAO.cliente.dataManagerDAO;
import com.loggeneratoribm.demo.model.cliente.DBConnection;
import com.loggeneratoribm.demo.model.cliente.DBProcedure;
import com.loggeneratoribm.demo.model.cliente.DBUser;
import com.loggeneratoribm.demo.model.cliente.newUser;

@RestController
public class dataManagerController{

    @Autowired
    private dataManagerDAO queries;
    
    @GetMapping("/dbusuarios") 
    public List<DBUser> getDBUSERS() {  
        return queries.ListALLDBUsers();
    }
    @GetMapping("/dbconexiones")
    public List<DBConnection> getConnections(){
        return queries.ListALLConnections();
    }
    @GetMapping("/dbproceduresxschema/{schemaName}")
	public List<DBProcedure> getProcedures(@PathVariable String schemaName) {
		return queries.ListALLSchemaProcedure(schemaName);
	}
    @PostMapping("/dbnuevoUsuario")
    public DBUser setNewUser(@RequestBody newUser usuarionuevo){
        return queries.CreateUser( usuarionuevo.getUsername(),usuarionuevo.getPassword());
    }

}
