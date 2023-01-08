package com.loggeneratoribm.demo.repositories.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.DAO.cliente.dataManagerDAO;
import com.loggeneratoribm.demo.model.cliente.DBConnection;
import com.loggeneratoribm.demo.model.cliente.DBProcedure;
import com.loggeneratoribm.demo.model.cliente.DBUser;

@Repository
public class dataManagerImpl implements dataManagerDAO{
    @Autowired
    JdbcTemplate template;
    @Override
    public List<DBUser> ListALLDBUsers() {
         String query="SELECT USERNAME as NOMBREUSUARIO, USER_ID as id ,CREATED as FECHA FROM sys.ALL_USERS";
        return template.query(query,new BeanPropertyRowMapper<DBUser>(DBUser.class));
    }

    @Override
    public DBUser CreateUser(String username, String password) { 
        String query="CREATE USER ? IDENTIFIED BY ?";
        Integer creacion=template.update(query, new Object[]{username,password});
        if (creacion==1) return template.queryForObject("SELECT USERNAME as NOMBREUSUARIO, USER_ID as id ,CREATED as FECHA FROM sys.ALL_USERS WHERE USERNAME=?",new BeanPropertyRowMapper<DBUser>(DBUser.class),username);
        else return new DBUser();
    }

    @Override
    public List<DBProcedure> ListALLSchemaProcedure(String schemaName) {
        String query="SELECT OBJECT_NAME AS NOMBRE ,OWNER AS SCHEMA  FROM SYS.ALL_PROCEDURES ap WHERE OWNER=?";
        return template.query(query,new BeanPropertyRowMapper<DBProcedure>(DBProcedure.class),schemaName);
    }

    @Override
    public List<DBConnection> ListALLConnections() {
        String query="SELECT  vs.USERNAME as USUARIO, vs.SID AS SID, vs.serial# as SERIAL,vs.LOGON_TIME as HORACONEXION, vs.status as ESTATUS"+ 
        "  FROM  sys.V_$SESSION vs "+
        " WHERE USERNAME <> 'NULL'"+
        " ORDER BY LOGON_TIME";
        return template.query(query,new BeanPropertyRowMapper<DBConnection>(DBConnection.class));
    }

    @Override
    public void DesconnectUser() {
        // TODO Auto-generated method stub
        
    }
    
}
