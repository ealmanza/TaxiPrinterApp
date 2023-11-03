package com.almaron.taxiprinter.Models.Getter;

public class Error {
    private final String title;
    private final String detail;

    public Error() {
        title = "";
        detail = "";
    }

    public Error(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

}
