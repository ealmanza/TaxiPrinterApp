package com.almaron.taxiprinter.Models.Getter;

public class Coordinate {

    private double latitude;
    private double longitude;
    private boolean isEmpty;

    public Coordinate() {
        latitude = 0.0;
        latitude = 0.0;
        isEmpty = false;
    }

    public Coordinate(double latitude, double longitude, boolean isEmpty) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.isEmpty = isEmpty;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

}
