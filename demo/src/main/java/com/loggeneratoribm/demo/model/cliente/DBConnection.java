package com.loggeneratoribm.demo.model.cliente;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DBConnection {
    @Column(name="USUARIO")
    private String usuario;
    @Column(name = "SID")
    private Integer sid;
    @Column(name = "SERIAL")
    private Long serial;
    @Column(name = "HORACONEXION")
    private LocalDateTime horaConexion;
    @Column(name = "ESTATUS")
    private String estatus;
}
