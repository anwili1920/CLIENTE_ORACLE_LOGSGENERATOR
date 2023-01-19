package com.loggeneratoribm.demo.dataBaseManager.repositories.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
 
import com.loggeneratoribm.demo.model.database.NameView;

public class ViewRowMapper implements RowMapper<NameView> {

    @Override 
    public NameView mapRow(ResultSet rs, int rowNum) throws SQLException {
        NameView view=new NameView();
        view.setOwner(rs.getString("OWNER"));
        view.setViewname(rs.getString("VIEW_NAME"));
        return view;
    }
    
}
