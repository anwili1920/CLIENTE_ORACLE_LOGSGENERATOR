package com.loggeneratoribm.demo.model.database;

public class PairUser {
    private String owneruser;
    private String otheruser;
    private String permiso;
    public PairUser() {
    }
    
    public PairUser(String owneruser, String otheruser, String permiso) {
        this.owneruser = owneruser;
        this.otheruser = otheruser;
        this.permiso = permiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

  
    public String getOwneruser() {
        return owneruser;
    }
    public void setOwneruser(String owneruser) {
        this.owneruser = owneruser;
    }
    public String getOtheruser() {
        return otheruser;
    }
    public void setOtheruser(String otheruser) {
        this.otheruser = otheruser;
    }

}
