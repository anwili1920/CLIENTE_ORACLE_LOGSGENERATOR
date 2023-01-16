package com.loggeneratoribm.demo.tamara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.model.tamara.Cliente;
import com.loggeneratoribm.demo.model.tamara.CurrentUser;
import com.loggeneratoribm.demo.model.tamara.Empresa;
import com.loggeneratoribm.demo.tamara.dao.TamaraDAO; 

@RestController
public class TamaraController {
    @Autowired
    private TamaraDAO tamaraDAO;
    @PostMapping("/ingresarempresa")
    public String setNuevaEmpresa(@RequestBody Empresa emp){
        return tamaraDAO.insertEmpresa(emp);
    }
    
    @GetMapping("/usuarioActual")
	public CurrentUser getUsuarioActual( ) {
		return tamaraDAO.getCurrentUser();
	}
    
    @GetMapping("/listarClientes")
	public List<Cliente> listarClientes( ) {
		return tamaraDAO.listarClientes();
	}
}
