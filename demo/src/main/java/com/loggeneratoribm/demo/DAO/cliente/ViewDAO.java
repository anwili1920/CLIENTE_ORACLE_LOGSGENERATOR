package com.loggeneratoribm.demo.DAO.cliente;

import java.util.List;

import com.loggeneratoribm.demo.model.cliente.View1;


public interface ViewDAO {
    public List<View1> findAll();
    public List<View1> findbyNameorLastName(String word);
}
