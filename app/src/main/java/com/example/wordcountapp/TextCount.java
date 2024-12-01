package com.example.wordcountapp;

public class TextCount {
    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("[\\s,.]+");
        return words.length;
    }

    public int countCharacters(String text) {
        if (text == null) {
            return 0;
        }
        return text.trim().length();
    }
}