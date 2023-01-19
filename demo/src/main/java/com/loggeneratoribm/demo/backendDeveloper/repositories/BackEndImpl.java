package com.loggeneratoribm.demo.backendDeveloper.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.backendDeveloper.dao.BackEndDAO;
import com.loggeneratoribm.demo.dataBaseManager.repositories.mappers.ClienteRowMapper;
import com.loggeneratoribm.demo.model.backend.Cliente;
import com.loggeneratoribm.demo.model.backend.CurrentUser;
import com.loggeneratoribm.demo.model.backend.Empresa;
@Service
public class BackEndImpl implements BackEndDAO{
    
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public String insertEmpresa(Empresa e) {
        String query="INSERT INTO CLIENTE_DB.EMPRESA(RUC,NOMBRE) VALUES (?,?)";
        Integer creacion=template.update(query, new Object[]{e.getRuc(),e.getNombre()});
        if (creacion==1) return "Se ingresó la empresa con ruc"+e.getRuc()+" Correctamente";
        else return "No se logró ingresar la empresa";
    }
    
    public CurrentUser getCurrentUser() {
        CurrentUser usuario= new CurrentUser();
        try {
            String query="select USER AS USUARIO from dual";
            usuario=(CurrentUser) template.queryForObject(query, new BeanPropertyRowMapper(CurrentUser.class));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----------------------------------------------");
			System.out.println("Debes iniciar Sesión para poder ejecutarlo");
			System.out.println("-----------------------------------------------");
        }
        return usuario;
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
