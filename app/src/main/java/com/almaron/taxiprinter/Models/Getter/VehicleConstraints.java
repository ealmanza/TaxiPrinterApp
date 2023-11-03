package com.almaron.taxiprinter.Models.Getter;

import java.util.ArrayList;

public class VehicleConstraints {

    private ArrayList<Object> forbiddenVehicles;
    private ArrayList<Object>requestedVehicles;

    public VehicleConstraints() {
        forbiddenVehicles =  new ArrayList<>();
        requestedVehicles =  new ArrayList<>();
    }

    public VehicleConstraints(ArrayList<Object> forbiddenVehicles, ArrayList<Object> requestedVehicles) {
        this.forbiddenVehicles = forbiddenVehicles;
        this.requestedVehicles = requestedVehicles;
    }

    public ArrayList<Object> getForbiddenVehicles() {
        return forbiddenVehicles;
    }

    public void setForbiddenVehicles(ArrayList<Object> forbiddenVehicles) {
        this.forbiddenVehicles = forbiddenVehicles;
    }

    public ArrayList<Object> getRequestedVehicles() {
        return requestedVehicles;
    }

    public void setRequestedVehicles(ArrayList<Object> requestedVehicles) {
        this.requestedVehicles = requestedVehicles;
    }

}
