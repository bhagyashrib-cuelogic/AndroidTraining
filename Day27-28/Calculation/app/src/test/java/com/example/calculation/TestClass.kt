package com.example.calculation


import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.junit.rules.Timeout
import org.junit.runner.RunWith
import java.lang.Character.getName


class TestClass {

    @Test(timeout=1000)
    fun add(){
        var sum = Calculation().add(2,2)
        assertEquals(4,sum)
        assertEquals(29,Calculation().add(20,9))
        assertEquals(10,Calculation().add(3,6))
    }
    @Test(timeout = 1000)
    fun multiplication(){
        assertEquals(10,Calculation().mul(2,5))
        assertEquals(90,Calculation().mul(15,6))
    }

    @Test(timeout = 1000)
    fun division(){
        assertEquals(1,Calculation().div(14,12))
    }
    
    
}