package com.loggeneratoribm.demo.model.database;

import java.time.LocalDateTime;

public class DBConnection {
	private String			usuario;
	private Integer			sid;
	private Long			serial;
	private LocalDateTime	horaConexion;
	private String			estatus;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public LocalDateTime getHoraConexion() {
		return horaConexion;
	}

	public void setHoraConexion(LocalDateTime horaConexion) {
		this.horaConexion = horaConexion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
