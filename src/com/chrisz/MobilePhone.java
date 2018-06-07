package com.chrisz;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contactList;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<Contact>();
    }


    public void addContact(String name, String number) {
        if (onFile(name)) {
            System.out.println("Contact already exists.");
        } else {
            Contact newContact = new Contact(name, number);
            contactList.add(newContact);
            System.out.println(name + " has been added to contacts.");
        }
    }


    public void modifyContactName(String oldName, String newName) {
        int position = findContact(oldName);
        if (onFile(newName)) {
            System.out.println(newName + " already exists in contacts.");
        } else if(position >= 0 ) {
            this.contactList.get(position).setName(newName);
            System.out.println(oldName + " has been updated to " + newName + ".");
        } else {
            System.out.println(oldName + " was not found in the contact list.");
        }

    }

    public void modifyContactNumber(String oldName, String newNumber) {
        int position = findContact(oldName);
        if (position >= 0) {
            this.contactList.get(position).setNumber(newNumber);
            System.out.println(oldName + " number been updated to " + newNumber + ".");
        }
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            this.contactList.remove(position);
            System.out.println(name + " has been removed from contacts.");
        } else {
            System.out.println(name + " does not exist in contacts.");
        }
    }

    public void listContact() {
        if (!this.contactList.isEmpty()) {
            for (int i = 0; i < this.contactList.size(); i++) {
                System.out.println(this.contactList.get(i).getName() + " - " + this.contactList.get(i).getNumber());
            }
        } else {
            System.out.println("No Contacts");
        }
    }

    private int findContact(String name) {
        //return this.contactList.indexOf(contact) instructor is passing object

        for (int i = 0; i < this.contactList.size(); i++) {
            //Contact contact = this.contactList.get(i);
            if (this.contactList.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public String getNumber(String name) {
        int position = findContact(name);
        return contactList.get(position).getNumber();
    }



    public boolean onFile(String name) {
        int position = findContact(name);
        return (position >= 0);
    }
}
