package com.almaron.taxiprinter.Models.Response;

import com.almaron.taxiprinter.Models.Getter.Outward;

import java.util.ArrayList;

public class QuoteResponse {

    private Outward outward;

    private String easyPayPaymentAmount;

    private String loyaltyCardMessage;

    private String loyaltyCardValid;

    private ArrayList<Object>errors;

    private ArrayList<Object>warnings;

    private int companyId;

    private String displayPriceCostMode;

    public QuoteResponse(Outward outward, String easyPayPaymentAmount, String loyaltyCardMessage, String loyaltyCardValid, ArrayList<Object> errors,
                         ArrayList<Object> warnings, int companyId, String displayPriceCostMode) {
        this.outward = outward;
        this.easyPayPaymentAmount = easyPayPaymentAmount;
        this.loyaltyCardMessage = loyaltyCardMessage;
        this.loyaltyCardValid = loyaltyCardValid;
        this.errors = errors;
        this.warnings = warnings;
        this.companyId = companyId;
        this.displayPriceCostMode = displayPriceCostMode;
    }

    public Outward getOutward() {
        return outward;
    }

    public void setOutward(Outward outward) {
        this.outward = outward;
    }

    public String getEasyPayPaymentAmount() {
        return easyPayPaymentAmount;
    }

    public void setEasyPayPaymentAmount(String easyPayPaymentAmount) {
        this.easyPayPaymentAmount = easyPayPaymentAmount;
    }

    public String getLoyaltyCardMessage() {
        return loyaltyCardMessage;
    }

    public void setLoyaltyCardMessage(String loyaltyCardMessage) {
        this.loyaltyCardMessage = loyaltyCardMessage;
    }

    public String getLoyaltyCardValid() {
        return loyaltyCardValid;
    }

    public void setLoyaltyCardValid(String loyaltyCardValid) {
        this.loyaltyCardValid = loyaltyCardValid;
    }

    public ArrayList<Object> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Object> errors) {
        this.errors = errors;
    }

    public ArrayList<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<Object> warnings) {
        this.warnings = warnings;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDisplayPriceCostMode() {
        return displayPriceCostMode;
    }

    public void setDisplayPriceCostMode(String displayPriceCostMode) {
        this.displayPriceCostMode = displayPriceCostMode;
    }


}
