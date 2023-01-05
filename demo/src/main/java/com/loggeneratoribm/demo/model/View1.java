package com.loggeneratoribm.demo.model;


 

import java.math.BigDecimal;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor@AllArgsConstructor
public class View1 {
    @Column(name = "ID_EMPLEADO")
    private String idEmpleado;
    @Column(name = "NUMERO_CONTRATO")
    private Integer numeroContrato; 
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO") 
    private String apellido;
    @Column(name = "MONTO")
    private BigDecimal  sueldo;
} 
