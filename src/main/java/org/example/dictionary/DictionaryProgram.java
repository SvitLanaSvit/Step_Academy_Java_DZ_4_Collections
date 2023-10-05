package org.example.dictionary;

import java.util.*;

public class DictionaryProgram {
    public static void getMenu() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> dictionary = new HashMap<>();
        Map<String, Integer> popularityCounter = new HashMap<>();

        while (true) {
            System.out.println("Dictionary Program Menu:");
            System.out.println("1. Add a word and its translation");
            System.out.println("2. Display word and its translations");
            System.out.println("3. Replace translation of a word");
            System.out.println("4. Delete translation of a word");
            System.out.println("5. Display top 10 most popular words");
            System.out.println("6. Display top 10 most unpopular words");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter a word in the source language: ");
                    String sourceWord = scanner.nextLine();
                    System.out.print("Enter its translation: ");
                    String translation = scanner.nextLine();
                    dictionary.put(sourceWord, translation);
                    popularityCounter.put(sourceWord, 0);
                    break;
                }
                case 2: {
                    System.out.print("Enter a word to display its translation: ");
                    String wordToDisplay = scanner.nextLine();
                    String translationToDisplay = dictionary.get(wordToDisplay);
                    if (translationToDisplay != null) {
                        System.out.println(wordToDisplay + " -> " + translationToDisplay);
                        popularityCounter.put(wordToDisplay, popularityCounter.getOrDefault(wordToDisplay, 0) + 1);
                    } else {
                        System.out.println("Word not found in the dictionary.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter a word to replace its translation: ");
                    String wordToReplace = scanner.nextLine();
                    if (dictionary.containsKey(wordToReplace)) {
                        System.out.print("Enter the new translation: ");
                        String newTranslation = scanner.next();
                        dictionary.put(wordToReplace, newTranslation);
                        System.out.println("Translation replaced successfully.");
                    } else {
                        System.out.println("Word not found in the dictionary.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter a word to delete its translation: ");
                    String wordToDelete = scanner.nextLine();
                    if (dictionary.containsKey(wordToDelete)) {
                        dictionary.remove(wordToDelete);
                        popularityCounter.remove(wordToDelete);
                        System.out.println("Translation deleted successfully.");
                    } else {
                        System.out.println("Word not found in the dictionary.");
                    }
                }
                case 5: {
                    displayTopPopularWords(popularityCounter);
                    break;
                }
                case 6: {
                    displayTopUnpopularWords(popularityCounter);
                    break;
                }
                case 7:{
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayTopPopularWords(Map<String, Integer> popularCounter) {
        System.out.println("Top 10 Most Popular Words:");
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(popularCounter.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int count = 0;
        for (var entry : entries) {
            if (count >= 10) {
                break;
            }
            System.out.println(entry.getKey() + " (Popularity Count: " + entry.getValue() + ")");
            count++;
        }

        System.out.println("-----------------------------");
    }

    private static void displayTopUnpopularWords(Map<String, Integer> popularCounter) {
        System.out.println("Top 10 Most Unpopular Words:");
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(popularCounter.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        int count = 0;
        for (var entry : entries) {
            if (count >= 10) {
                break;
            }
            System.out.println(entry.getKey() + " (Popularity Count: " + entry.getValue() + ")");
            count++;
        }

        System.out.println("-----------------------------");
    }
}
