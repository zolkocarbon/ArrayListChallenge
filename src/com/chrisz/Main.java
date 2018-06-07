package com.chrisz;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("7274581449");

    public static void main(String[] args) {

        boolean quit = false;
        int choice;
        printMenu();
        while (!quit) {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    findContact();
                    break;
                case 5:
                    mobilePhone.listContact();
                    //listContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println(choice + " is not a menu option, please enter 0-6");
            }
        }

    }

    public static void printMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To add a new contact");
        System.out.println("\t 2 - To modify a contact");
        System.out.println("\t 3 - To remove a contact.");
        System.out.println("\t 4 - To find a contact.");
        System.out.println("\t 5 - To list contacts.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact() {
        System.out.print("Please enter the contact name: ");
        String newContact = scanner.nextLine();
        System.out.print("please enter the contact number: ");
        //scanner.nextLine(); //********************
        mobilePhone.addContact(newContact, scanner.nextLine());

    }

    public static void modifyContact() {
        System.out.print("Please enter name of contact to modify: ");
        String oldContactName = scanner.nextLine();

        if (mobilePhone.onFile(oldContactName)) {
            System.out.println("Press 1 to modify name or 2 to modify number: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Please enter updated name: ");
                scanner.nextLine();
                mobilePhone.modifyContactName(oldContactName, scanner.nextLine());
            } else if (choice == 2) {
                System.out.println("Please enter new number: ");
                scanner.nextLine();
                mobilePhone.modifyContactNumber(oldContactName, scanner.nextLine());
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void removeContact() {
        System.out.print("Please enter name of contact to remove: ");
        //scanner.nextLine();
        mobilePhone.removeContact(scanner.nextLine());

    }

    public static void findContact() {
        System.out.println("Please enter name of contact to find: ");
        String name = scanner.nextLine();
        if (mobilePhone.onFile(name)) {
            String number = mobilePhone.getNumber(name);
            System.out.println(name + ": " + number);
        } else {
            System.out.println(name + " is not in contacts.");
        }
    }

//    public static void listContact() {
//        mobilePhone.listContact();
//    }
}
// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.