package com.loggeneratoribm.demo.backendDeveloper.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.loggeneratoribm.demo.model.backend.Cliente;
import com.loggeneratoribm.demo.model.backend.CurrentUser;
import com.loggeneratoribm.demo.model.backend.Empresa;

public interface BackEndDAO {
    public String insertEmpresa(Empresa e);
    public CurrentUser getCurrentUser();
	public List<Cliente> listarClientes();
    public void setTemplate(JdbcTemplate template);
}
