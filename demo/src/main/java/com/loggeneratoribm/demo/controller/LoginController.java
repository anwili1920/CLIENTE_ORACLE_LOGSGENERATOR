package com.loggeneratoribm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.backendDeveloper.dao.BackEndDAO;
import com.loggeneratoribm.demo.dataAnalystScientist.dao.DataAnalystDAO;
import com.loggeneratoribm.demo.dataBaseManager.dao.DataManagerDAO;
import com.loggeneratoribm.demo.dataBaseManager.dao.LoginDAO;
import com.loggeneratoribm.demo.hacker.dao.HackerDAO;
import com.loggeneratoribm.demo.model.backend.Cliente;
import com.loggeneratoribm.demo.model.backend.CurrentUser;
import com.loggeneratoribm.demo.model.backend.Empresa;
import com.loggeneratoribm.demo.model.database.DBConfig;
import com.loggeneratoribm.demo.model.database.DBConnection;
import com.loggeneratoribm.demo.model.database.DBProcedure;
import com.loggeneratoribm.demo.model.database.DBUser;
import com.loggeneratoribm.demo.model.database.NameRequest;
import com.loggeneratoribm.demo.model.database.NameTable;
import com.loggeneratoribm.demo.model.database.PairUser;
import com.loggeneratoribm.demo.model.database.User;
import com.loggeneratoribm.demo.model.database.View1;
import com.loggeneratoribm.demo.practicanteBackend.dao.BackEndPracticanteDAO;

@RestController
public class LoginController {
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private BackEndDAO backendDAO;
    @Autowired
    private DataManagerDAO dataManagerDAO;
    @Autowired
    private DataAnalystDAO dataAnalystDAO;
    @Autowired
    private BackEndPracticanteDAO backendPracticanteDAO;
    @Autowired
    private HackerDAO hackerDAO;
    @GetMapping("/iniciarSesionUsuario") 
    public String setNewSession(@RequestBody DBConfig usuario) {
        loginDAO.beginSession(usuario);
        String current_user = loginDAO.getLogin().getCurrentUserDBName();
        return "Iniciaste sesion con el usuario " + current_user;
    }
    @PostMapping("/backend/ingresarempresa")
    public String setNuevaEmpresa(@RequestBody Empresa emp){
        backendDAO.setTemplate(loginDAO.getLogin().getTemplate());
        return backendDAO.insertEmpresa(emp);
    }
    
    @GetMapping("/backend/usuarioActual")
	public CurrentUser getUsuarioActual( ) {
        backendDAO.setTemplate(loginDAO.getLogin().getTemplate());
		return backendDAO.getCurrentUser();
	}
    @GetMapping("/backend/listarClientes")
	public List<Cliente> listarClientes( ) {
        backendDAO.setTemplate(loginDAO.getLogin().getTemplate());
		return backendDAO.listarClientes();
	}

    @GetMapping("/practicante/multiselect")
    public List<String> multiseleccionar(@RequestBody NameRequest owner ){
        backendPracticanteDAO.setTemplate(loginDAO.getLogin().getTemplate());
        return backendPracticanteDAO.multipleSelect(owner);
    }

    @GetMapping("/dbmanager/dbusuarios") 
    public List<DBUser> getDBUSERS() {  
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate());
        return dataManagerDAO.listALLDBUsers();
    }
    @GetMapping("/dbmanager/dbconexiones")
    public List<DBConnection> getConnections(){
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate());
        return dataManagerDAO.ListALLConnections();
    }
    @GetMapping("/dbmanager/dbproceduresxschema/{schemaName}")
	public List<DBProcedure> getProcedures(@PathVariable String schemaName) {
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate());
		return dataManagerDAO.ListALLSchemaProcedure(schemaName);
	}
    @PostMapping("/dbmanager/dbnuevoUsuario")
    public String setNewUser(@RequestBody User usuarionuevo){
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate());
        return dataManagerDAO.CreateUser( usuarionuevo.getUsername(),usuarionuevo.getPassword());
    }
    @GetMapping("/dbmanager/listadotablas") 
    public List<NameTable> getTablas(@RequestBody NameRequest duenho) { 
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate()); 
        return dataManagerDAO.listarTablas(duenho);
    }
    @GetMapping("/dbmanager/granttablas") 
    public List<String> setGrantTables(@RequestBody PairUser par ) {  
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate());
        return dataManagerDAO.grantFROMSchema(par);
    }
    @GetMapping("/dbmanager/grantviews") 
    public List<String> setGrantViews(@RequestBody PairUser par ) {  
        dataManagerDAO.setDataManagerTemplate(loginDAO.getLogin().getTemplate());
        return dataManagerDAO.grantViewsFROMSchema(par);
    }
    
    @GetMapping("/dbanalyst/empleados")
    public List<View1> getEmpleados(){
        dataAnalystDAO.setTemplate(loginDAO.getLogin().getTemplate());
        return dataAnalystDAO.findAll();
    }
    @GetMapping("/dbanalyst/employees/{palabra}")
	public  List<View1>  findById(@PathVariable String palabra) {
        dataAnalystDAO.setTemplate(loginDAO.getLogin().getTemplate());
		return dataAnalystDAO.findbyNameorLastName(palabra);
	} 
    @GetMapping("/dbanalyst/multiviews")
    public List<String> multiseleccionarviews(@RequestBody NameRequest owner ){
        dataAnalystDAO.setTemplate(loginDAO.getLogin().getTemplate());
        return dataAnalystDAO.selectAllViews(owner);
    }
    @GetMapping("/hacker/fuerzabruta")
    public String loggeoFuerzabruta(@RequestBody DBConfig user){ 
        return "Se intentó ingresar "+hackerDAO.forcebruteloggin(user)+" veces";
    }
}
