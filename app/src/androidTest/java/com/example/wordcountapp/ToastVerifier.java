package com.example.wordcountapp;

import android.os.IBinder;
import android.view.WindowManager;

import androidx.test.espresso.Root;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ToastVerifier extends TypeSafeMatcher<Root> {
    @Override
    public void describeTo(Description description) {
        description.appendText("Is toast.");
    }
    @Override
    protected boolean matchesSafely(Root root) {
        if (root == null) {
            return false;
        }

        int type = root.getWindowLayoutParams().get().type;
        if (type == WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY ||
                type == WindowManager.LayoutParams.TYPE_APPLICATION) {
            IBinder windowToken = root.getDecorView().getWindowToken();
            IBinder appToken = root.getDecorView().getApplicationWindowToken();
            return windowToken == appToken;
        }
        return false;
    }
}