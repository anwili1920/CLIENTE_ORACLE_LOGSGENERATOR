package com.loggeneratoribm.demo.repositories.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.dao.cliente.ViewDAO;
import com.loggeneratoribm.demo.model.cliente.View1;


@Repository
public class ViewDAOImpl implements ViewDAO{
    @Autowired
    JdbcTemplate template;
    @Override
    public List<View1> findAll() {
        // TODO Auto-generated method stub
        String query="SELECT empleado.Id_Empleado , contrato.Numero_Contrato,persona.Nombre1 AS NOMBRE, persona.Apellido1 AS APELLIDO ,sueldos.Monto AS MONTO "+
        "from CLIENTE_DB.Empleado empleado, CLIENTE_DB.Sueldos sueldos, CLIENTE_DB.Persona  persona, CLIENTE_DB.Contrato  contrato "+
        "WHERE persona.Id_Persona=empleado.Fid_Persona AND sueldos.Fid_Contrato=contrato.Id_Contrato AND empleado.Fid_Contrato=contrato.Id_Contrato AND contrato.Id_Contrato=sueldos.Fid_Contrato "+
        "ORDER BY empleado.Id_Empleado";
        //String query="SELECT COUNT(ID_EMPLEADO) AS ID_EMPLEADO FROM ADMIN_RIMAC.EMPLEADO";
        return template.query(query, new BeanPropertyRowMapper<View1>(View1.class));

    }

    @Override
    public List<View1> findbyNameorLastName(String word) {
        // TODO Auto-generated method stub
        return null;
    }
}
