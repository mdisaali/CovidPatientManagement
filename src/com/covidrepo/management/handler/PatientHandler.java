package com.covidrepo.management.handler;

import com.covidrepo.management.constants.Constants;
import com.covidrepo.management.model.Patient;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PatientHandler {

    /**
     * In this module, the application will prompt the user to enter the following details
     * one by one:
     * a. Aadhaar Id
     * b. Name
     * c. State
     * d. City
     * e. PinCode
     * f. Status (Positive/Recovered/Deceased)
     * <p>
     * On successfully entering all the above details, the patient will be added to our in-memory
     * repository.
     */
    public void addPatient(Scanner scanner) {

        String aadharId = null;
        System.out.println("\nPlease Enter the following details:\nAadhar Id :\t");
        do {
            aadharId = scanner.nextLine();
            //aadhar id should be of 12 digits
            if (aadharId.length() != Constants.AADHAR_LENGTH)
                System.out.println("Aadhar id not valid. Please try again");
        } while (aadharId.length() != Constants.AADHAR_LENGTH);

        if (patientByAadharId(aadharId) != null) {
            System.out.println("Patient with aadhar id" + aadharId + " is already present. ");
            return;
        }

        Patient patient = new Patient();
        patient.setAadharId(aadharId);

        System.out.println("Name :\t");
        patient.setName(scanner.nextLine());

        System.out.println("State :\t");
        patient.setState(scanner.nextLine());

        System.out.println("City :\t");
        patient.setCity(scanner.nextLine());

        System.out.println("Pin Code :\t");
        patient.setPinCode(scanner.nextLong());
        scanner.nextLine();

        setPatientStatus(scanner, patient);

        Constants.patients.add(patient);

        Integer i = null;
        System.out.println("Patient Details added successfully!");
        System.out.println("Press 1 to add one more patient");
        System.out.println("Press 0 to go to main menu");
        i = scanner.nextInt();
        scanner.nextLine();

        if (i == 1) {
            addPatient(scanner);
        } else if (i == 0) {
        } else {
            System.out.println("Invalid Input. Please try again");
        }

    }

    /**
     * @param aadharId aadhar id by the user
     * @return patient object with the same aadhar id.
     */
    private Patient patientByAadharId(String aadharId) {
        for (Patient patient : Constants.patients) {
            if (patient.getAadharId().equals(aadharId)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * sets the status of the patient after validatng the input
     */
    private void setPatientStatus(Scanner scanner, Patient patient) {
        String status = null;
        do {
            System.out.println("Status (Positive/Recovered/Deceased) :\t");
            status = scanner.nextLine();
        } while (!validateStatus(status));

        patient.setStatus(status.toUpperCase());
    }

    /**
     * checks the user input with the available patient statuses
     */
    private boolean validateStatus(String status) {
        if (Constants.STATUS_1.equalsIgnoreCase(status) || Constants.STATUS_2.equalsIgnoreCase(status) || Constants.STATUS_3.equalsIgnoreCase(status))
            return true;
        else {
            System.out.println("Status not valid.");
            return false;
        }
    }

    /**
     * This module allows the user to update the status of the patient.
     * On successful status update, the user should be presented with an update message,
     * and an option to update another patient or go to the main menu.
     */
    public void updateStatus(Scanner scanner) {
        System.out.println("\nPlease Enter the Aadhar Id of the patient you want to update:\t");
        String aadharId = scanner.nextLine();
        Patient patient = patientByAadharId(aadharId);
        if (patient == null) {
            System.out.println("Patient with aadhar id " + aadharId + " is not found. ");
            return;
        }

        System.out.println("You can update the status of the patient now.");
        setPatientStatus(scanner, patient);
        System.out.println("Patient Details updated successfully!");

        Integer i = null;
        System.out.println("Press 1 to update one more patient");
        System.out.println("Press 0 to go to main menu");
        i = scanner.nextInt();
        scanner.nextLine();

        if (i == 1) {
            updateStatus(scanner);
        } else if (i == 0) {
        } else {
            System.out.println("Invalid Input. Please try again");
        }
    }

    /**
     * This module allows the user to enter the search criteria (aadhaar id, status, city, state, pincode),
     * and returns the list of patients matching the provided search criteria.
     * After presenting the search result, the user should be provided with an option to search again or
     * go to the main menu.
     */
    public void searchPatients(Scanner scanner) {
        System.out.println("\nEnter Search Text: \t");
        String searchString = scanner.nextLine();

        Set<String> searchResult = new HashSet<>();

        for (Patient patient : Constants.patients) {
            if (null != patient.getAadharId() && patient.getAadharId().toUpperCase().contains(searchString.toUpperCase())) {
                searchResult.add(patient.toString());
            } else if (null != patient.getName() && patient.getName().toUpperCase().contains(searchString.toUpperCase())) {
                searchResult.add(patient.toString());
            } else if (null != patient.getState() && patient.getState().toUpperCase().contains(searchString.toUpperCase())) {
                searchResult.add(patient.toString());
            } else if (null != patient.getCity() && patient.getCity().toUpperCase().contains(searchString.toUpperCase())) {
                searchResult.add(patient.toString());
            } else if (null != patient.getPinCode() && patient.getPinCode().toString().toUpperCase().contains(searchString.toUpperCase())) {
                searchResult.add(patient.toString());
            } else if (null != patient.getStatus() && patient.getStatus().toUpperCase().contains(searchString.toUpperCase())) {
                searchResult.add(patient.toString());
            }
        }

        System.out.println("\nSearch results for text:" + searchString);
        for (String s : searchResult) {
            System.out.println(s);
        }

        Integer i = null;
        System.out.println("Press 1 to search once more");
        System.out.println("Press 0 to go to main menu");
        i = scanner.nextInt();
        scanner.nextLine();

        if (i == 1) {
            searchPatients(scanner);
        } else if (i == 0) {
        } else {
            System.out.println("Invalid Input. Please try again");
        }
    }

}
