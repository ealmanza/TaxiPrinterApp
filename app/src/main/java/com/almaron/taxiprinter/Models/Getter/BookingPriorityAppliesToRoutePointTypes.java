package com.almaron.taxiprinter.Models.Getter;

public class BookingPriorityAppliesToRoutePointTypes {

    private final boolean pickup;
    private final boolean via;
    private final boolean destination;

    public BookingPriorityAppliesToRoutePointTypes() {
        this.pickup = false;
        this.via = false;
        this.destination = false;
    }

    public BookingPriorityAppliesToRoutePointTypes(boolean pickup, boolean via, boolean destination) {
        this.pickup = pickup;
        this.via = via;
        this.destination = destination;
    }

    public boolean isPickup() {
        return pickup;
    }

    public boolean isVia() {
        return via;
    }

    public boolean isDestination() {
        return destination;
    }

}
