package com.loggeneratoribm.demo.model.database;

public class DBConfig {
	private String	username;
	private String	password;
	private String driverClass;
	private String driverURL;
	private String schema;
	 
	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getDriverURL() {
		return driverURL;
	}

	public void setDriverURL(String driverURL) {
		this.driverURL = driverURL;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
