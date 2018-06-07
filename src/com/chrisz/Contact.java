package com.chrisz;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // instructor used this in class - called factory method pattern
    // made static so that it can be called without first having an object
    public static Contact createContact(String name, String number) {
        return new Contact(name, number);
    }
}
