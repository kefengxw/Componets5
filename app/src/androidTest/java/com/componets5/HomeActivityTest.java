package com.componets5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HomeActivityTest {

    @Before
    public void setUp(){
        System.out.println("HomeActivityTest Start testing");
    }

    @Test
    public void onCreate() {
        //onView(withId(R.id.textView)).perform(click());
        //onView(withId(R.id.textView)).check((ViewAssertion) withText("Hello World!"));
    }

    @Test
    public void onBackPressed() {
    }

    @Test
    public void onCreateOptionsMenu() {
    }

    @Test
    public void onOptionsItemSelected() {
    }

    @Test
    public void onNavigationItemSelected() {
    }

    @After
    public void tearDown(){
        System.out.println("HomeActivityTest End testing");
    }
}