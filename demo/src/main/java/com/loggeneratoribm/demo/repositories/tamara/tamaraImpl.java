package com.loggeneratoribm.demo.repositories.tamara;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loggeneratoribm.demo.dao.tamara.TamaraDAO;
import com.loggeneratoribm.demo.model.tamara.Cliente;
import com.loggeneratoribm.demo.model.tamara.CurrentUser;
import com.loggeneratoribm.demo.model.tamara.Empresa;
import com.loggeneratoribm.demo.repositories.tamara.mappers.ClienteRowMapper;
@Repository
public class TamaraImpl implements TamaraDAO{
    @Autowired
    @Qualifier("tamaraJDBC")
    JdbcTemplate template;
    
    public String insertEmpresa(Empresa e) {
        String query="INSERT INTO CLIENTE_DB.EMPRESA(RUC,NOMBRE) VALUES (?,?)";
        Integer creacion=template.update(query, new Object[]{e.getRuc(),e.getNombre()});
        if (creacion==1) return "Se ingresó la empresa con ruc"+e.getRuc()+" Correctamente";
        else return "No se logró ingresar la empresa";
    }
    
    public CurrentUser getCurrentUser() {
        
        String query="select USER AS USUARIO from dual";
        return (CurrentUser) template.queryForObject(query, new BeanPropertyRowMapper(CurrentUser.class));
    }

	@Override
	public List<Cliente> listarClientes() {
		List<Cliente> listado = new ArrayList<Cliente>();
		try {
			final String QUERY = "SELECT * FROM cliente";
			listado = template.query(QUERY, new ClienteRowMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}
    
}
