package com.example.calculation

import android.util.Log
import junit.framework.TestResult
import junit.framework.TestSuite


class TestSuitsClass {
    fun main(args: Array<String>){

        var suite :TestSuite =
            TestSuite(TestClass::class.java, SubTest::class.java)
        val result = TestResult()
        suite.run(result);

        Log.i("@Main","no of tests are ${result.runCount()}")

    }


}