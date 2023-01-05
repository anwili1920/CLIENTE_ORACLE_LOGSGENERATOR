package com.loggeneratoribm.demo.DAO;

import java.util.List;

import com.loggeneratoribm.demo.model.DBConnection;
import com.loggeneratoribm.demo.model.DBProcedure;
import com.loggeneratoribm.demo.model.DBUser;

public interface dataManagerDAO {
    public List<DBUser> ListALLDBUsers();
    public  DBUser CreateUser(String username,String password);
    public  List<DBProcedure>ListALLSchemaProcedure(String schemaName);
    public List<DBConnection> ListALLConnections();
    public  void DesconnectUser();
}
