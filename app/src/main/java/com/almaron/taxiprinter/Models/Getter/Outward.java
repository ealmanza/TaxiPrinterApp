package com.almaron.taxiprinter.Models.Getter;

public class Outward {

    private double distance;

    private  String measurement;

    private double price;

    private double cost;

    private String tariff;

    private String source;

    private String bookingCost;

    private String bookingPrice;

    private String time;

    private int discount;

    public Outward(double distance, String measurement, double price, double cost, String tariff, String source, String bookingCost, String bookingPrice, String time, int discount) {
        this.distance = distance;
        this.measurement = measurement;
        this.price = price;
        this.cost = cost;
        this.tariff = tariff;
        this.source = source;
        this.bookingCost = bookingCost;
        this.bookingPrice = bookingPrice;
        this.time = time;
        this.discount = discount;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(String bookingCost) {
        this.bookingCost = bookingCost;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
