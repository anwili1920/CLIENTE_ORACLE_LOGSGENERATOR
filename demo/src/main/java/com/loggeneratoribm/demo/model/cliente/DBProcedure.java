package com.loggeneratoribm.demo.model.cliente;
 
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DBProcedure {
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "SCHEMA")
    private String schema;
}
