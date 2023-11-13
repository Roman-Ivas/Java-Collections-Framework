package org.example;

import java.util.HashMap;
import java.util.Map;

public class TaxDatabase {
    private Map<String, Person> database;

    public TaxDatabase() {
        this.database = new HashMap<>();
    }

    public void printFullDatabase() {
        System.out.println("Tax Inspection Database:");
        for (Person person : database.values()) {
            System.out.println(person);
        }
    }

    public void printDataByCode(String personalIdentificationCode) {
        if (database.containsKey(personalIdentificationCode)) {
            System.out.println("Data for Personal Identification Code " + personalIdentificationCode + ":");
            System.out.println(database.get(personalIdentificationCode));
        } else {
            System.out.println("Person with Personal Identification Code " + personalIdentificationCode + " not found.");
        }
    }

    public void printDataByFineType(String fineType) {
        System.out.println("Data for Fine Type " + fineType + ":");
        for (Person person : database.values()) {
            for (Fine fine : person.getFines()) {
                if (fine.getType().equalsIgnoreCase(fineType)) {
                    System.out.println(person);
                    break;
                }
            }
        }
    }

    public void printDataByCity(String city) {
        System.out.println("Data for City " + city + ":");
        for (Person person : database.values()) {
            if (person.getCity().equalsIgnoreCase(city)) {
                System.out.println(person);
            }
        }
    }

    public void addNewPerson(Person person) {
        database.put(person.getPersonalIdentificationCode(), person);
    }

    public void addNewFine(String personalIdentificationCode, Fine fine) {
        if (database.containsKey(personalIdentificationCode)) {
            database.get(personalIdentificationCode).addFine(fine);
        } else {
            System.out.println("Person with Personal Identification Code " + personalIdentificationCode + " not found.");
        }
    }

    public void removeFine(String personalIdentificationCode, Fine fine) {
        if (database.containsKey(personalIdentificationCode)) {
            database.get(personalIdentificationCode).removeFine(fine);
        } else {
            System.out.println("Person with Personal Identification Code " + personalIdentificationCode + " not found.");
        }
    }

    public void replaceInformation(String personalIdentificationCode, String name, String city) {
        if (database.containsKey(personalIdentificationCode)) {
            database.get(personalIdentificationCode).replaceInformation(name, city);
        } else {
            System.out.println("Person with Personal Identification Code " + personalIdentificationCode + " not found.");
        }
    }
}
