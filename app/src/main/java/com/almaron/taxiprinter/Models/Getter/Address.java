package com.almaron.taxiprinter.Models.Getter;

public class Address {

    private int bookingPriority;
    private Coordinate coordinate;
    private String id;
    private boolean isCustom;
    private String source;
    private String street;
    private String text;
    private String town;
    private Zone zone;
    private int zoneId;

    public Address() {
        bookingPriority = 0;
        coordinate =  new Coordinate();
        id = "";
        isCustom = true;
        source = "";
        street = "";
        text = "";
        town = "";
        zone =  new Zone();
        zoneId = 0;
    }

    public Address(int bookingPriority, Coordinate coordinate, String id, boolean isCustom, String source, String street, String text, String town, Zone zone, int zoneId) {
        this.bookingPriority = bookingPriority;
        this.coordinate = coordinate;
        this.id = id;
        this.isCustom = isCustom;
        this.source = source;
        this.street = street;
        this.text = text;
        this.town = town;
        this.zone = zone;
        this.zoneId = zoneId;
    }

    public int getBookingPriority() {
        return bookingPriority;
    }

    public void setBookingPriority(int bookingPriority) {
        this.bookingPriority = bookingPriority;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(boolean isCustom) {
        this.isCustom = isCustom;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

}
