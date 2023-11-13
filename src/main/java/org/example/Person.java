package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String personalIdentificationCode;
    private String name;
    private String city;
    private List<Fine> fines;

    public Person(String personalIdentificationCode, String name, String city) {
        this.personalIdentificationCode = personalIdentificationCode;
        this.name = name;
        this.city = city;
        this.fines = new ArrayList<>();
    }

    public String getPersonalIdentificationCode() {
        return personalIdentificationCode;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFine(Fine fine) {
        fines.add(fine);
    }

    public void removeFine(Fine fine) {
        fines.remove(fine);
    }

    public void replaceInformation(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personalIdentificationCode='" + personalIdentificationCode + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", fines=" + fines +
                '}';
    }
}
