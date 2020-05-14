package com.example.hellotest

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters
import java.util.regex.Pattern.matches

@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FirstTest {
    @Rule
   public var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java
    )

    public class ActivityTestRule<T>(java: Class<MainActivity>) {

    }

    @Before
     fun setUp() {
    }
    @Test
    fun testText(){
        onView(withId(R.id.Hello)).check(matches(withText("Hello World!")))
    }

    private fun ViewAssertion(function: Matcher<View>?): ViewAssertion? = null
}



