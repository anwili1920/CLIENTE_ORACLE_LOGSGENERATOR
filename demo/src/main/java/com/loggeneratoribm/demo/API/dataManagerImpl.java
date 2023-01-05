package com.loggeneratoribm.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.DAO.dataManagerDAO;
import com.loggeneratoribm.demo.model.DBConnection;
import com.loggeneratoribm.demo.model.DBProcedure;
import com.loggeneratoribm.demo.model.DBUser;

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
        //String query="CREATE USER ? IDENTIFIED BY ?";
        //template.query(query, , null)
        return null;
    }

    @Override
    public List<DBProcedure> ListALLSchemaProcedure(String schemaName) {
        String query="SELECT OBJECT_NAME,OWNER  FROM SYS.ALL_PROCEDURES ap WHERE OWNER=?";
        return template.query(query,new BeanPropertyRowMapper<DBProcedure>(DBProcedure.class));
    }

    @Override
    public List<DBConnection> ListALLConnections() {
        String query="SELECT  USERNAME, sid,  serial# ,LOGON_TIME  , status FROM   v$session  WHERE USERNAME<> 'NULL' ORDER BY LOGON_TIME";
        return template.query(query,new BeanPropertyRowMapper<DBConnection>(DBConnection.class));
    }

    @Override
    public void DesconnectUser() {
        // TODO Auto-generated method stub
        
    }
    
}
