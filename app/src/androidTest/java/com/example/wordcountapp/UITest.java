package com.example.wordcountapp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UITest {

    @Test
    public void testWordCountFunctionality() {
        try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(MainActivity.class)) {
            Espresso.onView(ViewMatchers.withId(R.id.editTextInput))
                    .perform(ViewActions.typeText("This is a test string."), ViewActions.closeSoftKeyboard());

            Espresso.onView(ViewMatchers.withId(R.id.CountType))
                    .perform(ViewActions.click());
            Espresso.onData(org.hamcrest.Matchers.is("Words")).perform(ViewActions.click());

            Espresso.onView(ViewMatchers.withId(R.id.buttonCount))
                    .perform(ViewActions.click());

            Espresso.onView(ViewMatchers.withId(R.id.textViewResult))
                    .check(ViewAssertions.matches(ViewMatchers.withText("Result: 5")));
        }
    }
    @Test
    public void testCharacterCountFunctionality() {
        try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(MainActivity.class)) {
            Espresso.onView(ViewMatchers.withId(R.id.editTextInput))
                    .perform(ViewActions.typeText("This is a test string."), ViewActions.closeSoftKeyboard());

            Espresso.onView(ViewMatchers.withId(R.id.CountType))
                    .perform(ViewActions.click());
            Espresso.onData(org.hamcrest.Matchers.is("Characters")).perform(ViewActions.click());

            Espresso.onView(ViewMatchers.withId(R.id.buttonCount))
                    .perform(ViewActions.click());

            Espresso.onView(ViewMatchers.withId(R.id.textViewResult))
                    .check(ViewAssertions.matches(ViewMatchers.withText("Result: 22")));
        }
    }
    @Test
    public void testEmptyInput() {
        try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(MainActivity.class)) {
            Espresso.onView(ViewMatchers.withId(R.id.editTextInput))
                    .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard());

            Espresso.onView(ViewMatchers.withId(R.id.buttonCount))
                    .perform(ViewActions.click());

            Espresso.onView(ViewMatchers.withText(R.string.empty_input))
                    .inRoot(new ToastVerifier())
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        }
    }
}