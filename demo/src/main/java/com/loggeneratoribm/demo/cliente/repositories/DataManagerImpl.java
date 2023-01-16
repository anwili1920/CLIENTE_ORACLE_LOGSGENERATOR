package com.loggeneratoribm.demo.cliente.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.cliente.dao.DataManagerDAO;
import com.loggeneratoribm.demo.model.cliente.DBConnection;
import com.loggeneratoribm.demo.model.cliente.DBProcedure;
import com.loggeneratoribm.demo.model.cliente.DBUser;

@Repository
public class DataManagerImpl implements DataManagerDAO {
	@Autowired
	@Qualifier("clienteJDBC")
	JdbcTemplate clienteTemplate;

	public List<DBUser> listALLDBUsers() {
		String query = "SELECT USERNAME as NOMBREUSUARIO, USER_ID as id ,CREATED as FECHA FROM sys.ALL_USERS";
		return clienteTemplate.query(query, new BeanPropertyRowMapper<DBUser>(DBUser.class));
	}

	public String CreateUser(String username, String password) {
		String statement="alter session set "+ '"'+"_ORACLE_SCRIPT"+'"'+"=true"; 
		clienteTemplate.update(statement);
		String query = "CREATE USER "+username +" IDENTIFIED BY "+password;
		Integer creacion = clienteTemplate.update(query);
		if (creacion == 1)
			return "Se ingresó el usuario "+username+" correctamente";
		else
			return "No se logró crear el usuario";
	}

	public List<DBProcedure> ListALLSchemaProcedure(String schemaName) {
		String query = "SELECT OBJECT_NAME AS NOMBRE ,OWNER AS SCHEMA  FROM SYS.ALL_PROCEDURES ap WHERE OWNER=?";
		return clienteTemplate.query(query, new BeanPropertyRowMapper<DBProcedure>(DBProcedure.class), schemaName);
	}

	public List<DBConnection> ListALLConnections() {
		String query = "SELECT  vs.USERNAME as USUARIO, vs.SID AS SID, vs.serial# as SERIAL,vs.LOGON_TIME as HORACONEXION, vs.status as ESTATUS" + "  FROM  sys.V_$SESSION vs " + " WHERE USERNAME <> 'NULL'" + " ORDER BY LOGON_TIME";
		return clienteTemplate.query(query, new BeanPropertyRowMapper<DBConnection>(DBConnection.class));
	}

	public void DesconnectUser() {
	}

}
