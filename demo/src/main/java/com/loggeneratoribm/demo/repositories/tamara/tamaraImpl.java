package com.loggeneratoribm.demo.repositories.tamara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.dao.tamara.TamaraDAO;
import com.loggeneratoribm.demo.model.tamara.CurrentUser;
import com.loggeneratoribm.demo.model.tamara.Empresa;
@Repository
public class TamaraImpl implements TamaraDAO{
    @Autowired
    JdbcTemplate template;
    @Override
    public String insertEmpresa(Empresa e) {
        String query="INSERT INTO CLIENTE_DB.EMPRESA(RUC,NOMBRE) VALUES (?,?)";
        Integer creacion=template.update(query, new Object[]{e.getRuc(),e.getNombre()});
        if (creacion==1) return "Se ingresó la empresa con ruc"+e.getRuc()+" Correctamente";
        else return "No se logró ingresar la empresa";
    }
    @Override
    public CurrentUser getCurrentUser() {
        
        String query="select USER AS USUARIO from dual";
        return template.queryForObject(query, CurrentUser.class);
    }
    
}
