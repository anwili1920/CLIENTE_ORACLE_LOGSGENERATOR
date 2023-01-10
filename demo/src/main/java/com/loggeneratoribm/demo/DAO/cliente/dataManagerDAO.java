package com.loggeneratoribm.demo.dao.cliente;

import java.util.List;

import com.loggeneratoribm.demo.model.cliente.DBConnection;
import com.loggeneratoribm.demo.model.cliente.DBProcedure;
import com.loggeneratoribm.demo.model.cliente.DBUser;

public interface DataManagerDAO {
    public List<DBUser> listALLDBUsers();
    public  DBUser CreateUser(String username,String password);
    public  List<DBProcedure>ListALLSchemaProcedure(String schemaName);
    public List<DBConnection> ListALLConnections();
    public  void DesconnectUser();
}
