package com.loggeneratoribm.demo.dataBaseManager.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.loggeneratoribm.demo.model.database.DBConnection;
import com.loggeneratoribm.demo.model.database.DBProcedure;
import com.loggeneratoribm.demo.model.database.DBUser;
import com.loggeneratoribm.demo.model.database.NameRequest;
import com.loggeneratoribm.demo.model.database.NameTable;
import com.loggeneratoribm.demo.model.database.NameView;
import com.loggeneratoribm.demo.model.database.PairUser;

public interface DataManagerDAO {
    public void setDataManagerTemplate(JdbcTemplate dataManagerTemplate);

    public List<DBUser> listALLDBUsers();
    public  String CreateUser(String username,String password);
    public  List<DBProcedure>ListALLSchemaProcedure(String schemaName);
    public List<DBConnection> ListALLConnections();
    public List<NameTable> listarTablas(NameRequest duenho);
    public List<String> grantFROMSchema(PairUser par); 
    public List<NameView> listarViews(NameRequest duenho);
    public List<String> grantViewsFROMSchema(PairUser par);
}
