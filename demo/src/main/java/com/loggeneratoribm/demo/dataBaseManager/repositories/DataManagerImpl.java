package com.loggeneratoribm.demo.dataBaseManager.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loggeneratoribm.demo.dataBaseManager.dao.DataManagerDAO;
import com.loggeneratoribm.demo.dataBaseManager.repositories.mappers.TableRowMapper;
import com.loggeneratoribm.demo.dataBaseManager.repositories.mappers.ViewRowMapper;
import com.loggeneratoribm.demo.model.database.DBConnection;
import com.loggeneratoribm.demo.model.database.DBProcedure;
import com.loggeneratoribm.demo.model.database.DBUser;
import com.loggeneratoribm.demo.model.database.NameRequest;
import com.loggeneratoribm.demo.model.database.NameTable;
import com.loggeneratoribm.demo.model.database.NameView;
import com.loggeneratoribm.demo.model.database.PairUser;

@Service
public class DataManagerImpl implements DataManagerDAO {
	
	JdbcTemplate dataManagerTemplate;

	public JdbcTemplate getDataManagerTemplate() {
		return dataManagerTemplate;
	}

	public void setDataManagerTemplate(JdbcTemplate dataManagerTemplate) {
		this.dataManagerTemplate = dataManagerTemplate;
	}

	public List<DBUser> listALLDBUsers() {
		List<DBUser> listado= new ArrayList<DBUser>();
		try{
		String query = "SELECT USERNAME as NOMBREUSUARIO, USER_ID as id ,CREATED as FECHA FROM sys.ALL_USERS";
		listado=dataManagerTemplate.query(query, new BeanPropertyRowMapper<DBUser>(DBUser.class));
		}catch(Exception e){
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos");
			System.out.println("-----------------------------------------------");
		}
		return listado;
	}

	public String CreateUser(String username, String password) {
		String statement="alter session set "+ '"'+"_ORACLE_SCRIPT"+'"'+"=true"; 
		dataManagerTemplate.update(statement);
		String query = "CREATE USER "+username +" IDENTIFIED BY "+password;
		Integer creacion = dataManagerTemplate.update(query);
		if (creacion == 1)
			return "Se ingresó el usuario "+username+" correctamente";
		else
			return "No se logró crear el usuario";
	}

	public List<DBProcedure> ListALLSchemaProcedure(String schemaName) {
		String query = "SELECT OBJECT_NAME AS NOMBRE ,OWNER AS SCHEMA  FROM SYS.ALL_PROCEDURES ap WHERE OWNER=?";
		return dataManagerTemplate.query(query, new BeanPropertyRowMapper<DBProcedure>(DBProcedure.class), schemaName);
	}

	public List<DBConnection> ListALLConnections() {
		List<DBConnection> listado= new ArrayList<DBConnection>();
		try{
			String query = "SELECT  vs.USERNAME as USUARIO, vs.SID AS SID, vs.serial# as SERIAL,vs.LOGON_TIME as HORACONEXION, vs.status as ESTATUS" + "  FROM  sys.V_$SESSION vs " + " WHERE USERNAME <> 'NULL'" + " ORDER BY LOGON_TIME";
			listado=dataManagerTemplate.query(query, new BeanPropertyRowMapper<DBConnection>(DBConnection.class));
		}catch(Exception e){
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos");
			System.out.println("-----------------------------------------------");
		}
		return listado;
	}
	

    public List<NameTable> listarTablas(NameRequest duenho) {
        List<NameTable> listado = new ArrayList<NameTable>();
		final String QUERY = "SELECT owner, table_name FROM all_tables WHERE owner='"+duenho.getNombre()+"'"; 
		try {
			listado = dataManagerTemplate.query(QUERY, new TableRowMapper());
		}
		catch (Exception e) {
		 	//e.printStackTrace();
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos para ver todas las tablas del schema ingresado");
			System.out.println("-----------------------------------------------");
		}
		return listado;
    } 
	public List<NameView> listarViews(NameRequest duenho) {
        List<NameView> listado = new ArrayList<NameView>();
		final String QUERY = "SELECT VIEW_NAME, OWNER FROM ALL_VIEWS WHERE owner='"+duenho.getNombre()+"'"; 
		try {
			listado = dataManagerTemplate.query(QUERY, new ViewRowMapper());
		}
		catch (Exception e) {
		 	//e.printStackTrace();
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos para ver todas las vistas del schema ingresado");
			System.out.println("-----------------------------------------------");
		}
		return listado;
    } 
    public List<String> grantFROMSchema(PairUser par) {
        List<String> listado = new ArrayList<String>();
        List<NameTable> tablas = new ArrayList<NameTable>();
        String QUERY;
		tablas=listarTablas(new NameRequest(par.getOwneruser()));
		try {
            for(NameTable t : tablas) {
                QUERY= "grant "+par.getPermiso()+" on "+par.getOwneruser()+"."+t.getTablename()+" to "+par.getOtheruser(); 
                dataManagerTemplate.update(QUERY);
                listado.add(QUERY);
            }
		}
		catch (Exception e) {
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos para otorgar permisos de "+par.getPermiso()+" de los schemas immplicados");
			System.out.println("-----------------------------------------------");
		}
		return listado;
    }
	public List<String> grantViewsFROMSchema(PairUser par) {
        List<String> listado = new ArrayList<String>();
        List<NameView> vistas = new ArrayList<NameView>();
        String QUERY;
		vistas=listarViews(new NameRequest(par.getOwneruser()));
		try {
            for(NameView t : vistas) {
                QUERY= "grant "+par.getPermiso()+" on "+par.getOwneruser()+"."+t.getViewname()+" to "+par.getOtheruser(); 
                dataManagerTemplate.update(QUERY);
                listado.add(QUERY);
            }
		}
		catch (Exception e) {
			System.out.println("-----------------------------------------------");
			System.out.println("No tiene el usuario con los permisos requeridos para otorgar permisos de "+par.getPermiso()+" de los schemas immplicados");
			System.out.println("-----------------------------------------------");
		}
		return listado;
    }	

}
