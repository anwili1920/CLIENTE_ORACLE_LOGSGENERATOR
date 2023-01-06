package com.loggeneratoribm.demo.model;
 

import java.time.LocalDateTime;

 
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DBUser {
    @Column(name ="NOMBREUSUARIO")
    private String nombreUsuario; 

    @Column(name ="ID")
    private long id;
    
    @Column(name ="FECHA")
    private LocalDateTime  fecha;
}
