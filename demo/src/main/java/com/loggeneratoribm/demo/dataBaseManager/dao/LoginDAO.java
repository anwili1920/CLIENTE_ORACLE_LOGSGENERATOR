package com.loggeneratoribm.demo.dataBaseManager.dao;

import com.loggeneratoribm.demo.config.NewSession;
import com.loggeneratoribm.demo.model.database.DBConfig;
import com.loggeneratoribm.demo.services.Login; 

public interface LoginDAO {
    public NewSession beginSession(DBConfig usuario); 
    public Login getLogin();
}
