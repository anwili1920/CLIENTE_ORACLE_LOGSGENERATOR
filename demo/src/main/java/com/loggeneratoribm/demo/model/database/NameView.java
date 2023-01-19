package com.loggeneratoribm.demo.model.database;

public class NameView {
    private String owner;
    private String viewname;
    public NameView() {
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getViewname() {
        return viewname;
    }
    public void setViewname(String viewname) {
        this.viewname = viewname;
    }
}
