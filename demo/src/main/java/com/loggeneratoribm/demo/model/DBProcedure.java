package com.loggeneratoribm.demo.model;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DBProcedure {
    private String nombre;
    private String schema;
}
