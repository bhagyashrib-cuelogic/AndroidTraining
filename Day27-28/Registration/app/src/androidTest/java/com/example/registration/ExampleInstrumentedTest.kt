package com.example.registration

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.regex.Matcher
import androidx.core.content.MimeTypeFilter.matches as matches1

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule :ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.registration", appContext.packageName)
    }

    @Test
    fun enter_firstName(){
        onView(withId(R.id.exit_fname)).perform(typeText("Bhagyashri"))
    }
    @Test
    fun enter_lastname(){
        onView((withId(R.id.exit_lname))).perform(typeText("Gaikwad"))
    }
    @Test
    fun onclicTest(){
        onView(withId(R.id.exit_fname)).perform(typeText("Suraj"))
        onView(withId(R.id.exit_lname)).perform(typeText("jadhav"))
        onView(withId(R.id.button)).perform(click())
       onView(withId(R.id.message)).check(matches(withText("Hello,Suraj jadhav")))
    }
}
