package com.example.calculation

import junit.framework.Assert.assertEquals
import org.junit.Test

class SubTest {

    @Test
    fun sub(){
        var sum = Calculation().sub(2,2)
        assertEquals(0,sum)
        assertEquals(11,Calculation().sub(20,9))
        assertEquals(-3,Calculation().sub(3,6))
    }
}