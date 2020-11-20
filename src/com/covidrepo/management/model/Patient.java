package com.covidrepo.management.model;

public class Patient {

    private String aadharId;
    private String name;
    private String state;
    private String city;
    private Long pinCode;
    private Status status;

    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(String status) {
        this.status = Status.getValue(status);
    }

    @Override
    public String toString() {
        return "Aadhar Id: " + this.getAadharId()
                + "\t" + "Name: " + this.getName()
                + "\t" + "State: " + this.getState()
                + "\t" + "City: " + this.getCity()
                + "\t" + "Pin Code: " + this.getPinCode()
                + "\t" + "Status: " + this.getStatus();
    }
}
