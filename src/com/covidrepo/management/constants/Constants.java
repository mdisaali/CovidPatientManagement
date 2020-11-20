package com.covidrepo.management.constants;

import com.covidrepo.management.model.Patient;

import java.util.ArrayList;
import java.util.List;

public interface Constants {

    List<Patient> patients = new ArrayList<>();
    String STATUS_1 = "POSITIVE";
    String STATUS_2 = "RECOVERED";
    String STATUS_3 = "DECREASED";
    Integer AADHAR_LENGTH = 12;
}
