package com.loggeneratoribm.demo.repositories.tamara.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.loggeneratoribm.demo.model.tamara.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(rs.getString("IDCLIENTE"));
		cliente.setRazon_social(rs.getString("RAZON_SOCIAL"));
		return cliente;
	}


}
