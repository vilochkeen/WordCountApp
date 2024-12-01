package com.example.wordcountapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private final TextCount textCount = new TextCount();

    @Test
    public void textCountWordsNullInput() {
        assertEquals(0, textCount.countWords(null));
    }
    @Test
    public void testCountCharactersNullInput() {
        assertEquals(0, textCount.countCharacters(null));
    }

    @Test
    public void testCountWordsValidInput() {
        assertEquals(5, textCount.countWords("I am a test string!"));
    }
    @Test
    public void testCountCharactersValidInput() {
        assertEquals(22, textCount.countCharacters("This is a test string."));
    }

    @Test
    public void testCountWordsEmptyInput() {
        assertEquals(0, textCount.countWords(""));
    }
    @Test
    public void testCountCharactersEmptyInput() {
        assertEquals(0, textCount.countCharacters(""));
    }
}