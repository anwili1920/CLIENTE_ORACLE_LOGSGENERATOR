package com.loggeneratoribm.demo.DAO;

import java.util.List;

import com.loggeneratoribm.demo.model.View1;


public interface ViewDAO {
    public List<View1> findAll();
    public List<View1> findbyNameorLastName(String word);
}
