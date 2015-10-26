package Clinic;

import java.util.Scanner;

/**
 * Created by Vlad on 22.10.2015.
 */
public class OurClinicRun {

    private static String SHOW_CLIENT_LIST = "Show client list";
    private static String ADD = "Add new client";
    private static String SEARCH_ClIENT = "Find client";
    private static String SEARCH_PET = "Find pet";
    private static String CHANGE_CLIENT_NAME = "Change client's name";
    private static String CHANGE_ANIMAL_NAME = "Change pet's name";
    private static String REMOVE_CLIENT = "Delete client";
    private static String REMOVE_PET = "Delete pet";
    private static String EXIT = "Exit";
    private static String slash = "-------------------";
    private static Scanner in;
    private static MyClinic clinic;

    public static void main(String[] args) {

        in = new Scanner(System.in);
        clinic = new MyClinic();
        clinic.addClient("Vasya", 21, new Dog("Rex", 2));
        clinic.addClient("Vlad", 19, new Cat("Max", 3));


        start();

    }


    public static int check(int selection, int a, int b) {
        while (selection < a || selection > b) {
            System.out.println("You entered wrong number. Please try again");
            selection = in.nextInt();
        }
        return selection;
    }

    /**
     * Method that makes user to choose to keep working in program or exit
     */
    public static void nextOperation() {
        System.out.println("Do you want to select new operation? yes/no");
        String selection = in.next();
        while (!selection.equalsIgnoreCase("yes") && !selection.equalsIgnoreCase("no")) {
            System.out.println("You entered wrong letter. Please try again");
            selection = in.next();
        }
        switch (selection) {
            case "Yes":
            case "yes":
            case "YES":
                start();
                break;
            case "NO":
            case "No":
            case "no":
                exit();
                break;
        }
    }

    /**
     * Start of the program
     * Entering main menu
     */
    private static void start() {
        System.out.println("--- Welcome to our Clinic ---");
        System.out.println("Choose next actions:");
        System.out.println(String.format("1) %s \n2) %s \n3) %s \n" +
                        "4) %s \n5) %s \n6) %s \n7) %s \n8) %s", SHOW_CLIENT_LIST, ADD,
                SEARCH_ClIENT, CHANGE_CLIENT_NAME, CHANGE_ANIMAL_NAME, REMOVE_CLIENT, REMOVE_PET, EXIT));
        int selection = in.nextInt();
        selection = check(selection, 1, 9);
        switch (selection) {
            case 1:
                showClientList();
                break;
            case 2:
                addClient();
                break;
            case 3:
                searchClient();
                break;
            case 4:
                changeClientName();
                break;
            case 5:
                changeAnimalName();
                break;
            case 6:
                removClient();
                break;
            case 7:
                removAnimal();
                break;
            case 8:
                exit();
                break;
        }
        System.out.println(slash);
    }

    /**
     * Shows list of clients
     */
    private static void showClientList() {
        System.out.println("--- Client list ---");
        clinic.showClients();
        System.out.println(slash);
        nextOperation();
    }

    /**
     * Add new client
     */
    public static void exit() {
        System.out.println("Do you really want to exit? yes/no");
        String selection = in.next();
        while (!selection.equalsIgnoreCase("yes") && !selection.equalsIgnoreCase("no")) {
            System.out.println("You entered wrong letter. Please try again");
            selection = in.next();
        }
        switch (selection) {
            case "YES":
            case "yes":
            case "Yes":

                System.out.println("Goodbye!");
                System.exit(0);
                break;
            case "NO":
            case "no":
            case "No":
                nextOperation();
                break;
        }
    }

    private static void addClient() {
        System.out.println("Enter client name: ");
        String clientName = in.next();
        System.out.println("Enter client age: ");
        int clientAge = in.nextInt();
        System.out.println("Choose type of pet: \n 1) Dog \n 2) Cat ");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        System.out.println("Enter client animal name");
        String animalName = in.next();
        System.out.println("Enter animal age:");
        int animalAge = in.nextInt();
        Animal animal = null;
        switch (selection) {
            case 1:
                animal = new Dog(animalName, clientAge);
                break;
            case 2:
                animal = new Cat(animalName, animalAge);
                break;

        }
        clinic.addClient(clientName, clientAge, animal);
        System.out.println("Client added to the list");
        clinic.showClients();
        System.out.println(slash);
        nextOperation();
    }

    private static void searchClient() {
        System.out.println("Search client:\n1) by Name \n2) by Pet's name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        switch (selection) {
            case 1:
                System.out.println("Enter client's name: ");
                String clientName = in.next();
                clinic.searchClientByName(clientName).toString();
                break;
            case 2:
                System.out.println("Enter pet's name: ");
                String petName = in.next();
                clinic.searchByAnimalName(petName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    private static void changeClientName() {
        System.out.println("Change client's name:\n1) by name");
        int selection = in.nextInt();
        String newName = null;
        switch (selection) {
            case 1:
                System.out.println("Enter previous client's name: ");
                String clientName = in.next();
                System.out.println("Enter new client's name: ");
                newName = in.next();
                clinic.changeClientName(clientName, newName);
                break;
        }
        System.out.println(slash);
        nextOperation();
    }

    private static void changeAnimalName() {
        System.out.println("Change pet's name:\n1) by id");
        int selection = in.nextInt();
        String newName = null;
        switch (selection) {
            case 1:
                System.out.println("Enter id: ");
                int id = in.nextInt();
                System.out.println("Enter new name: ");
                newName = in.next();
                clinic.changeAnimalNameById(id, newName);
                break;

        }
        System.out.println(slash);
        nextOperation();
    }

    private static void removClient() {
        System.out.println("Remove client:\n1) by id \n2) by name");
        int selection = in.nextInt();
        selection = check(selection, 1, 2);
        switch (selection) {
            case 1:
                System.out.println("Enter id: ");
                int id = in.nextInt();
                clinic.removClientById(id);
                break;
            case 2:
                System.out.println("Enter client's name: ");
                String clientName = in.next();
                clinic.removClientByName(clientName);
                break;
        }

        System.out.println(slash);
        nextOperation();
    }

    private static void removAnimal() {
        System.out.println("Remove pet:\n1) by name");
        int selection = in.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Enter pet's name: ");
                String petName = in.next();
                clinic.removeAnimal(petName);
                break;

        }
        System.out.println(slash);
        nextOperation();
    }
}