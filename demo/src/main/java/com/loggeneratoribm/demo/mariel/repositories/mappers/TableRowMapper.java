package com.loggeneratoribm.demo.mariel.repositories.mappers;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper; 
import java.sql.SQLException;
import com.loggeneratoribm.demo.model.NameTable;

public class TableRowMapper implements RowMapper<NameTable> {
    @Override
    public NameTable mapRow(ResultSet rs,int rowNum) throws SQLException{
        NameTable table=new NameTable();
        table.setTablename(rs.getString("TABLE_NAME"));
        return table;
    }
}
