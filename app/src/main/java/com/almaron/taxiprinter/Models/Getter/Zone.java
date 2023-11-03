package com.almaron.taxiprinter.Models.Getter;

public class Zone {

    private int id;
    private String name;
    private String descriptor;
    private int mdtZoneId;

    public Zone() {
        id = 0;
        name = "";
        descriptor = "";
        mdtZoneId = 0;
    }

    public Zone(int id, String name, String descriptor, int mdtZoneId) {
        this.id = id;
        this.name = name;
        this.descriptor = descriptor;
        this.mdtZoneId = mdtZoneId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public int getMdtZoneId() {
        return mdtZoneId;
    }

    public void setMdtZoneId(int mdtZoneId) {
        this.mdtZoneId = mdtZoneId;
    }

}
