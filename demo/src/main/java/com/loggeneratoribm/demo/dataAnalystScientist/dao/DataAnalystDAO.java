package com.loggeneratoribm.demo.dataAnalystScientist.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.loggeneratoribm.demo.model.database.NameRequest;
import com.loggeneratoribm.demo.model.database.View1;

public interface DataAnalystDAO {
    public List<View1> findAll();
    public List<View1> findbyNameorLastName(String word);
    public void setTemplate(JdbcTemplate template);
    public List<String> selectAllViews(NameRequest owner);
}
