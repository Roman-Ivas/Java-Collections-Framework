package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    private Map<String, String> translations;
    private Map<String, Integer> wordPopularity;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.wordPopularity = new HashMap<>();
    }

    public void addTranslation(String word, String translation) {
        translations.put(word, translation);
        wordPopularity.put(word, wordPopularity.getOrDefault(word, 0) + 1);
    }

    public void displayTranslations() {
        System.out.println("Dictionary Translations:");
        for (Map.Entry<String, String> entry : translations.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void addWord(String word, String translation) {
        addTranslation(word, translation);
    }

    public void replaceTranslation(String word, String newTranslation) {
        if (translations.containsKey(word)) {
            translations.put(word, newTranslation);
            wordPopularity.put(word, wordPopularity.getOrDefault(word, 0) + 1);
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    public void deleteTranslation(String word) {
        if (translations.containsKey(word)) {
            translations.remove(word);
            wordPopularity.remove(word);
            System.out.println("Translation deleted successfully.");
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    public void deleteWord(String word) {
        if (translations.containsKey(word)) {
            translations.remove(word);
            wordPopularity.remove(word);
            System.out.println("Word and its translation deleted successfully.");
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    public void displayTopWords(int count, boolean popular) {
        System.out.println("Top " + count + " " + (popular ? "Popular" : "Unpopular") + " Words:");

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordPopularity.entrySet());
        sortedList.sort((entry1, entry2) -> popular ? entry2.getValue().compareTo(entry1.getValue()) : entry1.getValue().compareTo(entry2.getValue()));

        for (int i = 0; i < Math.min(count, sortedList.size()); i++) {
            System.out.println(sortedList.get(i).getKey() + " - " + sortedList.get(i).getValue() + " appeals");
        }
    }
}
