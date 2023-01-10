package com.loggeneratoribm.demo.model.cliente;
 

import java.time.LocalDateTime;

public class DBUser {
    private String nombreUsuario; 

    private long id;
    
    private LocalDateTime  fecha;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
}
