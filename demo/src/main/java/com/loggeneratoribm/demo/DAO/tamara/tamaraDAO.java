package com.loggeneratoribm.demo.DAO.tamara;

import com.loggeneratoribm.demo.model.tamara.currentUser;
import com.loggeneratoribm.demo.model.tamara.empresa;

public interface tamaraDAO {
    public String insertEmpresa(empresa e);
    public currentUser getCurrentUser();
}
