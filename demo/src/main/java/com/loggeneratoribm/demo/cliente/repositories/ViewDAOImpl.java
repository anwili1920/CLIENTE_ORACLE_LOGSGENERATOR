package com.loggeneratoribm.demo.cliente.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.cliente.dao.ViewDAO;
import com.loggeneratoribm.demo.model.cliente.View1;

@Repository
public class ViewDAOImpl implements ViewDAO {
	@Autowired
	@Qualifier("clienteJDBC")
	JdbcTemplate template;

	public List<View1> findAll() {

		String query = "SELECT empleado.Id_Empleado , contrato.Numero_Contrato,persona.Nombre1 AS NOMBRE, persona.Apellido1 AS APELLIDO ,sueldos.Monto AS MONTO " + "from CLIENTE_DB.Empleado empleado, CLIENTE_DB.Sueldos sueldos, CLIENTE_DB.Persona  persona, CLIENTE_DB.Contrato  contrato " + "WHERE persona.Id_Persona=empleado.Fid_Persona AND sueldos.Fid_Contrato=contrato.Id_Contrato AND empleado.Fid_Contrato=contrato.Id_Contrato AND contrato.Id_Contrato=sueldos.Fid_Contrato " + "ORDER BY empleado.Id_Empleado";
		return template.query(query, new BeanPropertyRowMapper<View1>(View1.class));

	}

	public List<View1> findbyNameorLastName(String word) {
		return null;
	}
}
