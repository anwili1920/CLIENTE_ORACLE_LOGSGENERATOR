package com.loggeneratoribm.demo.mariel.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.mariel.dao.DBAdminDAO;
import com.loggeneratoribm.demo.mariel.repositories.mappers.TableRowMapper;
import com.loggeneratoribm.demo.model.NameTable;
import com.loggeneratoribm.demo.model.PairUser;
import com.loggeneratoribm.demo.model.mariel.NameRequest;

@Repository
public class DBAdminImpl implements DBAdminDAO {
    @Autowired
    @Qualifier("marielJDBC")
    JdbcTemplate template;
    @Override
    public List<NameTable> listarTablas(NameRequest duenho) {
        List<NameTable> listado = new ArrayList<NameTable>();
		try {
			final String QUERY = "SELECT owner, table_name FROM all_tables WHERE owner='"+duenho.getNombre()+"'"; 
			listado = template.query(QUERY, new TableRowMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
    }
    @Override
    public List<String> selectGrantFROMSchema(PairUser par) {
        List<String> listado = new ArrayList<String>();
        List<NameTable> tablas = new ArrayList<NameTable>();
        String QUERY;
		try {
            tablas=listarTablas(new NameRequest(par.getOwneruser()));
            for(NameTable t : tablas) {
                QUERY= "grant "+par.getPermiso()+" on "+par.getOwneruser()+"."+t.getTablename()+" to "+par.getOtheruser(); 
                template.update(QUERY);
                listado.add(QUERY);
            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
    }
    
}
