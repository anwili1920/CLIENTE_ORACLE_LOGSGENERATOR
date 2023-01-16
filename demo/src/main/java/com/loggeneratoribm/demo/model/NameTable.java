package com.loggeneratoribm.demo.model;

public class NameTable {
    // private String owner;
    private String tablename;
    public NameTable() {
    }
    public NameTable( String tablename) {
        // this.owner = owner;
        this.tablename = tablename;
    }
    // public String getOwner() {
    //     return owner;
    // }
    // public void setOwner(String owner) {
    //     this.owner = owner;
    // }
    public String getTablename() {
        return tablename;
    }
    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

}
