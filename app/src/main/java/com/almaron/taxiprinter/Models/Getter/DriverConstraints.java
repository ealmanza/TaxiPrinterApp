package com.almaron.taxiprinter.Models.Getter;

import java.util.ArrayList;

public class DriverConstraints {

    private ArrayList<Object>forbiddenDrivers;
    private ArrayList<Object>requestedDrivers;

    public DriverConstraints() {
        forbiddenDrivers = new ArrayList<>();
        requestedDrivers = new ArrayList<>();
    }

    public DriverConstraints(ArrayList<Object> forbiddenDrivers, ArrayList<Object> requestedDrivers) {
        this.forbiddenDrivers = forbiddenDrivers;
        this.requestedDrivers = requestedDrivers;
    }

    public ArrayList<Object> getForbiddenDrivers() {
        return forbiddenDrivers;
    }

    public void setForbiddenDrivers(ArrayList<Object> forbiddenDrivers) {
        this.forbiddenDrivers = forbiddenDrivers;
    }

    public ArrayList<Object> getRequestedDrivers() {
        return requestedDrivers;
    }

    public void setRequestedDrivers(ArrayList<Object> requestedDrivers) {
        this.requestedDrivers = requestedDrivers;
    }

}
