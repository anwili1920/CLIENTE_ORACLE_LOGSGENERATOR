package com.loggeneratoribm.demo.mariel.dao;

import java.util.List;

import com.loggeneratoribm.demo.model.NameTable;
import com.loggeneratoribm.demo.model.PairUser;
import com.loggeneratoribm.demo.model.mariel.NameRequest;

public interface DBAdminDAO {
    public List<NameTable> listarTablas(NameRequest duenho);
    public List<String> selectGrantFROMSchema(PairUser par);
}
