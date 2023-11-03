package com.almaron.taxiprinter.Models.Getter;

public class PickupDestination {

    private Address address;
    private boolean completed;
    private String note;
    private String passengerDetailsIndex;
    private String type;

    public PickupDestination() {
    }

    public PickupDestination(Address address, boolean completed, String note, String passengerDetailsIndex, String type) {
        this.address = address;
        this.completed = completed;
        this.note = note;
        this.passengerDetailsIndex = passengerDetailsIndex;
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPassengerDetailsIndex() {
        return passengerDetailsIndex;
    }

    public void setPassengerDetailsIndex(String passengerDetailsIndex) {
        this.passengerDetailsIndex = passengerDetailsIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
