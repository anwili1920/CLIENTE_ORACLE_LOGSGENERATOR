package com.loggeneratoribm.demo.model.tamara;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class currentUser {
    @Column(name ="USUARIO")
    private String usuario;  
}
