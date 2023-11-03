package com.almaron.taxiprinter.Models.Getter;

public class CliOptions {

    private String cliBookingStatus;
    private boolean isMobileNumber;
    private String ivrStatus;
    private String ringbackStatus;

    public CliOptions() {
        cliBookingStatus = "NotSet";
        isMobileNumber = false;
        ivrStatus = "NotSet";
        ringbackStatus = "NotSet";
    }

    public CliOptions(String cliBookingStatus, boolean isMobileNumber, String ivrStatus, String ringbackStatus) {
        this.cliBookingStatus = cliBookingStatus;
        this.isMobileNumber = isMobileNumber;
        this.ivrStatus = ivrStatus;
        this.ringbackStatus = ringbackStatus;
    }

    public String getCliBookingStatus() {
        return cliBookingStatus;
    }

    public void setCliBookingStatus(String cliBookingStatus) {
        this.cliBookingStatus = cliBookingStatus;
    }

    public boolean isMobileNumber() {
        return isMobileNumber;
    }

    public void setMobileNumber(boolean mobileNumber) {
        isMobileNumber = mobileNumber;
    }

    public String getIvrStatus() {
        return ivrStatus;
    }

    public void setIvrStatus(String ivrStatus) {
        this.ivrStatus = ivrStatus;
    }

    public String getRingbackStatus() {
        return ringbackStatus;
    }

    public void setRingbackStatus(String ringbackStatus) {
        this.ringbackStatus = ringbackStatus;
    }

}
