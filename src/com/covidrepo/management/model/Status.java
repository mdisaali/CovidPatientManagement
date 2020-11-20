package com.covidrepo.management.model;

public enum Status {

    POSITIVE,
    RECOVERED,
    DECREASED;

    public static Status getValue(String s){
        return (Status) Enum.valueOf(Status.class, s);
    }

}
