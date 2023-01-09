package com.loggeneratoribm.demo.dao.tamara;

import com.loggeneratoribm.demo.model.tamara.currentUser;
import com.loggeneratoribm.demo.model.tamara.empresa;

public interface TamaraDAO {
    public String insertEmpresa(empresa e);
    public currentUser getCurrentUser();
}
