package com.loggeneratoribm.demo.practicanteBackend.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.loggeneratoribm.demo.model.database.NameRequest;

public interface BackEndPracticanteDAO {
  
    public void setTemplate(JdbcTemplate template);
    public List<String> multipleSelect(NameRequest owner);
}
