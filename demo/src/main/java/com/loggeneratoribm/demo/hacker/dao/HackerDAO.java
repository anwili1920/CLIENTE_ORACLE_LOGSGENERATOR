package com.loggeneratoribm.demo.hacker.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.loggeneratoribm.demo.model.database.DBConfig;

public interface HackerDAO { 
    public Integer forcebruteloggin(DBConfig user);
}
