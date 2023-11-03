package com.almaron.taxiprinter.Models.Response;

public class DefaultResponse {

    private final String bookingId;

    public DefaultResponse(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

}
