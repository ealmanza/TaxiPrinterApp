package com.almaron.taxiprinter.Models.Response;

import com.almaron.taxiprinter.Models.Getter.BookingPriorityAppliesToRoutePointTypes;
import com.almaron.taxiprinter.Models.Getter.Coordinate;
import com.almaron.taxiprinter.Models.Getter.Error;
import com.almaron.taxiprinter.Models.Getter.Zone;

import java.util.ArrayList;
import java.util.List;

public class StreetsDbResponse {

    private final String source;
    private final String id;
    private final boolean isCustom;
    private final String searchTypeLetter;
    private final Zone zone;
    private final BookingPriorityAppliesToRoutePointTypes bookingPriorityAppliesToRoutePointTypes;
    private final String text;
    private final int zoneId;
    private final Coordinate coordinate;
    private final String note;
    private final String house;
    private final String street;
    private final String town;
    private final String postCode;
    private final int bookingPriority;
    private List<Error> errors;

    public StreetsDbResponse() {
        source = "";
        id = "";
        isCustom = false;
        searchTypeLetter = "";
        zone = new Zone();
        bookingPriorityAppliesToRoutePointTypes = new BookingPriorityAppliesToRoutePointTypes();
        text = "";
        zoneId = 0;
        coordinate = new Coordinate();
        note = "";
        house = "";
        street = "";
        town = "";
        postCode = "";
        bookingPriority = 0;
        errors = new ArrayList<>();
    }

    public StreetsDbResponse(String source, String id, boolean isCustom, String searchTypeLetter, Zone zone, BookingPriorityAppliesToRoutePointTypes bookingPriorityAppliesToRoutePointTypes,
                             String text, int zoneId, Coordinate coordinate, String note, String house, String street, String town, String postCode, int bookingPriority, List<Error> errors) {
        this.source = source;
        this.id = id;
        this.isCustom = isCustom;
        this.searchTypeLetter = searchTypeLetter;
        this.zone = zone;
        this.bookingPriorityAppliesToRoutePointTypes = bookingPriorityAppliesToRoutePointTypes;
        this.text = text;
        this.zoneId = zoneId;
        this.coordinate = coordinate;
        this.note = note;
        this.house = house;
        this.street = street;
        this.town = town;
        this.postCode = postCode;
        this.bookingPriority = bookingPriority;
        this.errors = errors;
    }

    public String getSource() {
        return source;
    }

    public String getId() {
        return id;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public String getSearchTypeLetter() {
        return searchTypeLetter;
    }

    public Zone getZone() {
        return zone;
    }

    public BookingPriorityAppliesToRoutePointTypes getBookingPriorityAppliesToRoutePointTypes() {
        return bookingPriorityAppliesToRoutePointTypes;
    }

    public String getText() {
        return text;
    }

    public int getZoneId() {
        return zoneId;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getNote() {
        return note;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getBookingPriority() {
        return bookingPriority;
    }

    public List<Error> getErrors() {
        return errors;
    }

}
