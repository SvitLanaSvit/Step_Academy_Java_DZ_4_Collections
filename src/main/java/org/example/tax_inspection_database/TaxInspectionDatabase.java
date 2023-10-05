package org.example.tax_inspection_database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class TaxInspectionDatabase {
    public static void getMenu(){
        Map<String, Person> database = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Tax Inspection Database Menu:");
            System.out.println("1. Display the entire database");
            System.out.println("2. Display data by specific code");
            System.out.println("3. Display data on a specific type of fine");
            System.out.println("4. Display data for a specific city");
            System.out.println("5. Add a new person with information about them");
            System.out.println("6. Add new fines to an existing record");
            System.out.println("7. Remove a fine");
            System.out.println("8. Replace information about a person and their fines");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:{
                    displayDatabase(database);
                    break;
                }
                case 2: {
                    displayDataByCode(database);
                    break;
                }
                case 3: {
                    displayDataByFineType(database);
                    break;
                }
                case 4: {
                    displayDataByCity(database);
                    break;
                }
                case 5: {
                    addNewPerson(database);
                    break;
                }
                case 6: {
                    addNewFineToPerson(database);
                    break;
                }
                case 7: {
                    removeFine(database);
                    break;
                }
                case 8: {
                    replacePersonInfo(database);
                    break;
                }
                case 9: {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayDatabase(Map<String, Person> database){
        System.out.println("Tax Inspection Database:");
        for(var person : database.values()){
            System.out.println(person);
        }
        System.out.println("-----------------------------");
    }

    private static void displayDataByCode(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the personal identification code: ");
        String id = scanner.next();
        var person = database.get(id);
        if(person != null){
            System.out.println("Data for ID " + id + ":");
            System.out.println(person);
        }else{
            System.out.println("Person not found in the database.");
        }
        System.out.println("-----------------------------");
    }

    private static void displayDataByFineType(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the fine type: ");
        String type = scanner.next();
        List<Person> matchingPersons = new ArrayList<>();
        for(Person person : database.values()){
            for(Fine fine : person.getFines()){
                if(fine.getType() == type){
                    matchingPersons.add(person);
                    break;
                }
            }
        }
        if(!matchingPersons.isEmpty()){
            System.out.println("Data for fines of type " + type + ":");
            for(Person person : matchingPersons){
                System.out.println(person);
            }
        }else{
            System.out.println("No data found for the specified fine type.");
        }
        System.out.println("-----------------------------");
    }

    private static void displayDataByCity(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();
        List<Person> matchingPersons = new ArrayList<>();
        for(Person person : database.values()){
            for(Fine fine : person.getFines()){
                if(fine.getCity().equals(city)){
                    matchingPersons.add(person);
                    break;
                }
            }
        }
        if(!matchingPersons.isEmpty()){
            System.out.println("Data for fines in the city " + city + ":");
            for(var person : matchingPersons){
                System.out.println(person);
            }
        }else{
            System.out.println("No data found for the specified city.");
        }
        System.out.println("-----------------------------");
    }

    private static void addNewPerson(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the personal identification code: ");
        String id = scanner.next();
        System.out.print("Enter the person's name: ");
        String name = scanner.next();

        if(!database.containsKey(id)){
            database.put(id, new Person(id, name));
            System.out.println("Person added to the database.");
        }else{
            System.out.println("Person with the same code already exists in the database.");
        }
        System.out.println("-----------------------------");
    }

    private static void addNewFineToPerson(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the personal identification code: ");
        String id = scanner.next();
        Person person = database.get(id);
        if(person != null){
            System.out.print("Enter the fine type: ");
            String type = scanner.next();
            System.out.print("Enter the fine amount: ");
            double amount = scanner.nextDouble();
            System.out.print("Enter the city for the fine: ");
            String city = scanner.next();
            person.addFine(new Fine(type,amount,city));
            System.out.println("Fine added to the person's record.");
        }else{
            System.out.println("Person not found in the database.");
        }
        System.out.println("-----------------------------");
    }

    private static void removeFine(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the personal identification code: ");
        String id = scanner.next();
        Person person = database.get(id);
        if( person != null){
            System.out.print("Enter the fine type to remove: ");
            String typeToRemove = scanner.next();
            List<Fine> fines = person.getFines();
            for(var fine : fines){
                if(fine.getType().equalsIgnoreCase(typeToRemove)){
                    person.removeFine(fine);
                    System.out.println("Fine removed from the person's record.");
                    return;
                }
            }
            System.out.println("Fine type not found in the person's record.");
        }else{
            System.out.println("Person not found in the database.");
        }
        System.out.println("-----------------------------");
    }

    private static void replacePersonInfo(Map<String, Person> database){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the personal identification code: ");
        String id = scanner.next();
        Person person = database.get(id);
        if(person != null){
            System.out.print("Enter the new name for the person: ");
            String newName = scanner.next();
            person = new Person(id, newName);
            database.put(id, person);
            System.out.println("Person information replaced.");
        }else{
            System.out.println("Person not found in the database.");
        }
        System.out.println("-----------------------------");
    }
}