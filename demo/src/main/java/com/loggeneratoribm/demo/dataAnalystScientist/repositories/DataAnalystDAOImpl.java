package com.loggeneratoribm.demo.dataAnalystScientist.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.dataAnalystScientist.dao.DataAnalystDAO;
import com.loggeneratoribm.demo.dataBaseManager.dao.DataManagerDAO;
import com.loggeneratoribm.demo.dataBaseManager.repositories.DataManagerImpl;
import com.loggeneratoribm.demo.model.database.NameRequest;
import com.loggeneratoribm.demo.model.database.NameView;
import com.loggeneratoribm.demo.model.database.View1;

@Service
public class DataAnalystDAOImpl implements DataAnalystDAO {
	 
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<View1> findAll() {

		String query = "SELECT empleado.Id_Empleado , contrato.Numero_Contrato,persona.Nombre1 AS NOMBRE, persona.Apellido1 AS APELLIDO ,sueldos.Monto AS MONTO " + "from CLIENTE_DB.Empleado empleado, CLIENTE_DB.Sueldos sueldos, CLIENTE_DB.Persona  persona, CLIENTE_DB.Contrato  contrato " + "WHERE persona.Id_Persona=empleado.Fid_Persona AND sueldos.Fid_Contrato=contrato.Id_Contrato AND empleado.Fid_Contrato=contrato.Id_Contrato AND contrato.Id_Contrato=sueldos.Fid_Contrato " + "ORDER BY empleado.Id_Empleado";
		return template.query(query, new BeanPropertyRowMapper<View1>(View1.class));

	}

	public List<View1> findbyNameorLastName(String word) {
		return null;
	}

	@Override
	public List<String> selectAllViews(NameRequest owner) {
		List<String> listado = new ArrayList<String>();
        List<NameView> vistas = new ArrayList<NameView>();
        String QUERY;
        DataManagerDAO aux= new DataManagerImpl();
        aux.setDataManagerTemplate(template);
		vistas=aux.listarViews(owner);
		try {
            for(NameView v : vistas) {
                QUERY= "SELECT * FROM "+v.getOwner()+"."+v.getViewname(); 
                template.update(QUERY);
                listado.add(QUERY);
            }
		}
		catch (Exception e) {
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos para realizar los selects correspientes");
			System.out.println("-----------------------------------------------");
		}
		return listado;
	}
}
