package org.example;


import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Course: Java programming language
        //Subject: Java Collections Framework
        //When implementing each of the tasks, you must select a class from the Java Collections Framework, which
        //suitable for the solution of the task.
        //
        //Task 1:
        //Create a simulation model of "mooring of sea boats". The following information must be entered:
        //1. the average time between the appearance of passengers at the pier at different times of the day,
        //2. the average time between the appearance of boats at the pier at different times of the day,
        //3. type of boat stop (final or not).
        //It is necessary to determine:
        //1. The average time a person stays at a stop.
        //2. A sufficient time interval between the arrival of boats so that there are no more than N people at the stop
        //simultaneously
        //3. The number of free seats in the boat is a random number.

        Pier pier = new Pier();
        Random random = new Random();

        // Simulate the arrival of passengers and boats
        for (int i = 0; i < 10; i++) {
            int numberOfPassengers = random.nextInt(10) + 1; // Random number of passengers
            pier.addPassenger(numberOfPassengers);

            int boatCapacity = random.nextInt(5) + 1; // Random boat capacity
            Boat boat = new Boat(boatCapacity);

            if (pier.isBoatAvailable() && pier.getPassengersQueueSize() > boatCapacity) {
                pier.moorBoat(boat);
                int passengers = pier.unloadBoat();
                System.out.println("Boat arrived. Unloaded " + passengers + " passengers.");
            }

            // Simulate time passing between boat arrivals
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }





        //Task 2:
        //Create a program for working with a dictionary. For example, English-Spanish, French-German or
        //any other direction. The program must:
        // provide initial data entry for the dictionary
        // allows displaying the word and its translations
        // allows you to add, replace, delete the translation of a word
        // allows you to add, replace, delete a word
        // displays the top 10 most popular words (we determine popularity based on the counter
        //appeals)
        // displays the top 10 most unpopular words (we determine popularity based on the counter
        //appeals)


        Dictionary dictionary = new Dictionary();

        // Initial data entry for the dictionary
        dictionary.addTranslation("Hello", "Hola");
        dictionary.addTranslation("Goodbye", "Adiós");
        dictionary.addTranslation("Cat", "Gato");

        // Display all translations
        dictionary.displayTranslations();

        // Add, replace, delete translation
        dictionary.addWord("Dog", "Perro");
        dictionary.replaceTranslation("Goodbye", "Hasta luego");
        dictionary.deleteTranslation("Hello");

        // Display all translations after modifications
        dictionary.displayTranslations();

        // Add, replace, delete word
        dictionary.addWord("Apple", "Manzana");
        dictionary.replaceTranslation("Dog", "Canino");
        dictionary.deleteWord("Cat");

        // Display all translations after modifications
        dictionary.displayTranslations();

        // Display top 10 most popular and unpopular words
        dictionary.displayTopWords(10, true);
        dictionary.displayTopWords(10, false);

        //Task 3:
        //Implement the tax inspection database on fines. It will be his to identify each person
        //personal identification code. One person can have many fines.
        //Realize:
        //1. Full printing of the database
        //2. Printing data by specific code
        //3. Printing data on a specific type of fine
        //4. Printing data for a specific city
        //5. Adding a new person with information about him
        //6. Adding new fines to an existing record
        //7. Removal of fine
        //8. Replacement of information about a person and his fines
        TaxDatabase taxDatabase = new TaxDatabase();

        // Adding sample data
        Person person1 = new Person("123456789", "John Doe", "City1");
        person1.addFine(new Fine("Speeding", 100.0));
        person1.addFine(new Fine("Parking", 50.0));

        Person person2 = new Person("987654321", "Jane Smith", "City2");
        person2.addFine(new Fine("Speeding", 150.0));
        person2.addFine(new Fine("No Seatbelt", 75.0));

        taxDatabase.addNewPerson(person1);
        taxDatabase.addNewPerson(person2);

        // Printing full database
        taxDatabase.printFullDatabase();

        // Printing data by specific code
        taxDatabase.printDataByCode("123456789");

        // Printing data by specific type of fine
        taxDatabase.printDataByFineType("Speeding");

        // Printing data for specific city
        taxDatabase.printDataByCity("City2");

        // Adding a new person
        Person person3 = new Person("111222333", "Bob Johnson", "City3");
        taxDatabase.addNewPerson(person3);

        // Adding new fines to an existing record
        taxDatabase.addNewFine("111222333", new Fine("Parking", 30.0));

        // Removing a fine
        taxDatabase.removeFine("111222333", new Fine("Parking", 30.0));

        // Replacement of information about a person and his fines
        taxDatabase.replaceInformation("111222333", "Robert Johnson", "City4");

        // Printing full database after modifications
        taxDatabase.printFullDatabase();

    }
}