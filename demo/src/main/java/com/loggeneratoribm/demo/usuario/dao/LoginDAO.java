package com.loggeneratoribm.demo.usuario.dao;

import com.loggeneratoribm.demo.model.DBConfig; 

public interface LoginDAO {
    public String beginSession(DBConfig usuario); 
}
