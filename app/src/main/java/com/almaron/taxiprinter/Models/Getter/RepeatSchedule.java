package com.almaron.taxiprinter.Models.Getter;

import java.util.ArrayList;

public class RepeatSchedule {

    private int bookingSuspensionGroupId;

    private String endTime;

    private String endTimeUtc;

    private boolean hasRepeats;

    private boolean isFortnightly;

    private ArrayList<Object> repeatDays;

    private ArrayList<Object> skippedDays;

    public RepeatSchedule() {
        bookingSuspensionGroupId = 0;
        endTime = "";
        endTimeUtc = "";
        hasRepeats = false;
        isFortnightly = false;
        repeatDays = new ArrayList<>();
        skippedDays = new ArrayList<>();
    }

    public RepeatSchedule(int bookingSuspensionGroupId, String endTime, String endTimeUtc, boolean hasRepeats, boolean isFortnightly, ArrayList<Object> repeatDays,
                          ArrayList<Object> skippedDays) {
        this.bookingSuspensionGroupId = bookingSuspensionGroupId;
        this.endTime = endTime;
        this.endTimeUtc = endTimeUtc;
        this.hasRepeats = hasRepeats;
        this.isFortnightly = isFortnightly;
        this.repeatDays = repeatDays;
        this.skippedDays = skippedDays;
    }

    public int getBookingSuspensionGroupId() {
        return bookingSuspensionGroupId;
    }

    public void setBookingSuspensionGroupId(int bookingSuspensionGroupId) {
        this.bookingSuspensionGroupId = bookingSuspensionGroupId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeUtc() {
        return endTimeUtc;
    }

    public void setEndTimeUtc(String endTimeUtc) {
        this.endTimeUtc = endTimeUtc;
    }

    public boolean isHasRepeats() {
        return hasRepeats;
    }

    public void setHasRepeats(boolean hasRepeats) {
        this.hasRepeats = hasRepeats;
    }

    public boolean isFortnightly() {
        return isFortnightly;
    }

    public void setFortnightly(boolean fortnightly) {
        isFortnightly = fortnightly;
    }

    public ArrayList<Object> getRepeatDays() {
        return repeatDays;
    }

    public void setRepeatDays(ArrayList<Object> repeatDays) {
        this.repeatDays = repeatDays;
    }

    public ArrayList<Object> getSkippedDays() {
        return skippedDays;
    }

    public void setSkippedDays(ArrayList<Object> skippedDays) {
        this.skippedDays = skippedDays;
    }

}
