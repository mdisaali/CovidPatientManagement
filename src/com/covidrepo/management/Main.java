package com.covidrepo.management;

import com.covidrepo.management.handler.PatientHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PatientHandler handler = new PatientHandler();

        Integer i = null;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("Press 1 to add a patient");
            System.out.println("Press 2 to update status of an existing patient");
            System.out.println("Press 3 to search patients");
            System.out.println("Press 0 to exit this program");

            i = scanner.nextInt();
            scanner.nextLine();

            switch (i) {
                case 1:
                    handler.addPatient(scanner);
                    break;
                case 2:
                    handler.updateStatus(scanner);
                    break;
                case 3:
                    handler.searchPatients(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input. please select an option from the given menu \n\n");
            }

        } while (i != 0);
    }
}
