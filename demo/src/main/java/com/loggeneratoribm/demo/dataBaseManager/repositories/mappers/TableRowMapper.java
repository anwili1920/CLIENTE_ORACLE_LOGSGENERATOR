package com.loggeneratoribm.demo.dataBaseManager.repositories.mappers;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.loggeneratoribm.demo.model.database.NameTable;

import java.sql.SQLException;

public class TableRowMapper implements RowMapper<NameTable> {
    @Override
    public NameTable mapRow(ResultSet rs,int rowNum) throws SQLException{
        NameTable table=new NameTable();
        table.setTablename(rs.getString("TABLE_NAME"));
        table.setOwner(rs.getString("OWNER"));
        return table;
    }
}
