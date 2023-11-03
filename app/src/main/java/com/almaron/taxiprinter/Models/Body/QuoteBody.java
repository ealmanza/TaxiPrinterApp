package com.almaron.taxiprinter.Models.Body;

import com.almaron.taxiprinter.Models.Getter.CliOptions;
import com.almaron.taxiprinter.Models.Getter.DriverConstraints;
import com.almaron.taxiprinter.Models.Getter.PickupDestination;
import com.almaron.taxiprinter.Models.Getter.RepeatSchedule;
import com.almaron.taxiprinter.Models.Getter.VehicleConstraints;
import com.almaron.taxiprinter.Models.Getter.YourReferences;

import java.util.ArrayList;

public class QuoteBody {

    private ArrayList<Object> capabilities;

    private CliOptions cliOptions;

    private int companyId;

    private PickupDestination destination;

    private DriverConstraints driverConstraints;

    private boolean isEasyPay;

    private ArrayList<Object> payByLinkDetails;

    private PickupDestination pickup;

    private String pickupDueTime;

    private String pickupDueTimeUtc;

    private boolean priorityOverride;

    private RepeatSchedule repeatSchedule;

    private VehicleConstraints vehicleConstraints;

    private boolean waitAndReturn;

    private YourReferences yourReferences;

    private boolean hold;

    public QuoteBody() {
        capabilities = new ArrayList<>();
        cliOptions = new CliOptions();
        companyId = 0;
        destination = new PickupDestination();
        driverConstraints = new DriverConstraints();
        isEasyPay = false;
        payByLinkDetails = new ArrayList<>();
        pickup = new PickupDestination();
        pickupDueTime = "";
        pickupDueTimeUtc = "";
        priorityOverride = false;
        repeatSchedule = new RepeatSchedule();
        vehicleConstraints = new VehicleConstraints();
        waitAndReturn = false;
        yourReferences = new YourReferences();
        hold = false;
    }

    public ArrayList<Object> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(ArrayList<Object> capabilities) {
        this.capabilities = capabilities;
    }

    public CliOptions getCliOptions() {
        return cliOptions;
    }

    public void setCliOptions(CliOptions cliOptions) {
        this.cliOptions = cliOptions;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public PickupDestination getDestination() {
        return destination;
    }

    public void setDestination(PickupDestination destination) {
        this.destination = destination;
    }

    public DriverConstraints getDriverConstraints() {
        return driverConstraints;
    }

    public void setDriverConstraints(DriverConstraints driverConstraints) {
        this.driverConstraints = driverConstraints;
    }

    public boolean getIsEasyPay() {
        return isEasyPay;
    }

    public void setIsEasyPay(boolean isEasyPay) {
        this.isEasyPay = isEasyPay;
    }

    public ArrayList<Object> getPayByLinkDetails() {
        return payByLinkDetails;
    }

    public void setPayByLinkDetails(ArrayList<Object> payByLinkDetails) {
        this.payByLinkDetails = payByLinkDetails;
    }

    public PickupDestination getPickup() {
        return pickup;
    }

    public void setPickup(PickupDestination pickup) {
        this.pickup = pickup;
    }

    public String getPickupDueTime() {
        return pickupDueTime;
    }

    public void setPickupDueTime(String pickupDueTime) {
        this.pickupDueTime = pickupDueTime;
    }

    public String getPickupDueTimeUtc() {
        return pickupDueTimeUtc;
    }

    public void setPickupDueTimeUtc(String pickupDueTimeUtc) {
        this.pickupDueTimeUtc = pickupDueTimeUtc;
    }

    public boolean isPriorityOverride() {
        return priorityOverride;
    }

    public void setPriorityOverride(boolean priorityOverride) {
        this.priorityOverride = priorityOverride;
    }

    public RepeatSchedule getRepeatSchedule() {
        return repeatSchedule;
    }

    public void setRepeatSchedule(RepeatSchedule repeatSchedule) {
        this.repeatSchedule = repeatSchedule;
    }

    public VehicleConstraints getVehicleConstraints() {
        return vehicleConstraints;
    }

    public void setVehicleConstraints(VehicleConstraints vehicleConstraints) {
        this.vehicleConstraints = vehicleConstraints;
    }

    public boolean isWaitAndReturn() {
        return waitAndReturn;
    }

    public void setWaitAndReturn(boolean waitAndReturn) {
        this.waitAndReturn = waitAndReturn;
    }

    public YourReferences getYourReferences() {
        return yourReferences;
    }

    public void setYourReferences(YourReferences yourReferences) {
        this.yourReferences = yourReferences;
    }

    public boolean isHold() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

}
