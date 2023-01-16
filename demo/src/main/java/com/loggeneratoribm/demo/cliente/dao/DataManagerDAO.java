package com.loggeneratoribm.demo.cliente.dao;

import java.util.List;

import com.loggeneratoribm.demo.model.cliente.DBConnection;
import com.loggeneratoribm.demo.model.cliente.DBProcedure;
import com.loggeneratoribm.demo.model.cliente.DBUser;

public interface DataManagerDAO {
    public List<DBUser> listALLDBUsers();
    public  String CreateUser(String username,String password);
    public  List<DBProcedure>ListALLSchemaProcedure(String schemaName);
    public List<DBConnection> ListALLConnections();
    public  void DesconnectUser();
}
