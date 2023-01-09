package com.loggeneratoribm.demo.dao.tamara;

import com.loggeneratoribm.demo.model.tamara.CurrentUser;
import com.loggeneratoribm.demo.model.tamara.Empresa;

public interface TamaraDAO {
    public String insertEmpresa(Empresa e);
    public CurrentUser getCurrentUser();
}
