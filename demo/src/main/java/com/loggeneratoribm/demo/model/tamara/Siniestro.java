package com.loggeneratoribm.demo.model.tamara;

import java.sql.Date;

public class Siniestro {
    private String siniestroNombre;
    private String descripcion;
    private Date fechaOcurrida;
    public Siniestro() {
    }
    public String getSiniestroNombre() {
        return siniestroNombre;
    }
    public void setSiniestroNombre(String siniestroNombre) {
        this.siniestroNombre = siniestroNombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaOcurrida() {
        return fechaOcurrida;
    }
    public void setFechaOcurrida(Date fechaOcurrida) {
        this.fechaOcurrida = fechaOcurrida;
    }
}
