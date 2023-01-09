package com.loggeneratoribm.demo.controller.tamara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.dao.tamara.TamaraDAO;
import com.loggeneratoribm.demo.model.tamara.currentUser;
import com.loggeneratoribm.demo.model.tamara.empresa; 

@RestController
public class tamaraController {
    @Autowired
    private TamaraDAO tamaraDAO;
    @PostMapping("/ingresarempresa")
    public String setNuevaEmpresa(@RequestBody empresa emp){
        return tamaraDAO.insertEmpresa(emp);
    }
    @GetMapping("/usuarioActual")
	public currentUser getUsuarioActual( ) {
		return tamaraDAO.getCurrentUser();
	}
}
