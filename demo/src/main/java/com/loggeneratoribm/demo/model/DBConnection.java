package com.loggeneratoribm.demo.model;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DBConnection {
    private String usuario;
    private Integer sid;
    private Long serial;
    private Date horaConexion;
}
