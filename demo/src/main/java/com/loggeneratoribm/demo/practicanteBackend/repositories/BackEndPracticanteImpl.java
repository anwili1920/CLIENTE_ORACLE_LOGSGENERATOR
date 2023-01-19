package com.loggeneratoribm.demo.practicanteBackend.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.dataBaseManager.dao.DataManagerDAO;
import com.loggeneratoribm.demo.dataBaseManager.repositories.DataManagerImpl;
import com.loggeneratoribm.demo.model.database.NameRequest;
import com.loggeneratoribm.demo.model.database.NameTable;
import com.loggeneratoribm.demo.practicanteBackend.dao.BackEndPracticanteDAO;
@Service
public class BackEndPracticanteImpl implements BackEndPracticanteDAO {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<String> multipleSelect(NameRequest owner) {
        List<String> listado = new ArrayList<String>();
        List<NameTable> tablas = new ArrayList<NameTable>();
        String QUERY;
        DataManagerDAO aux= new DataManagerImpl();
        aux.setDataManagerTemplate(template);
		tablas=aux.listarTablas(owner);
		try {
            for(NameTable t : tablas) {
                QUERY= "SELECT * FROM "+t.getOwner()+"."+t.getTablename(); 
                template.update(QUERY);
                listado.add(QUERY);
            }
		}
		catch (Exception e) {
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos para realizar los selects correspientes");
			System.out.println("-----------------------------------------------");
		}
		return listado;
        
    }
 
}
