package com.loggeneratoribm.demo.controller;
import java.util.List;
 
 
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.loggeneratoribm.demo.DAO.ViewDAO;
import com.loggeneratoribm.demo.model.View1;

  
@RestController
public class ViewController1 {
      
    @Autowired
    private ViewDAO queries;
    @GetMapping("/empleados")
    public List<View1> getEmpleados(){
        return queries.findAll();
    }
    @GetMapping("/employees/{palabra}")
	public  List<View1>  findById(@PathVariable String palabra) {
		return queries.findbyNameorLastName(palabra);
	}
}
