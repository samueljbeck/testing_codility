package com.samuelbeck.codilitytests

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/*
 * Created by samueljbeck on 2/21/19.
 */
class TimeComplexity {
    @Test
    fun timeComplexityTest() {

        assertEquals(3, solution(10,85,30))


        assertEquals(0, solution(10,10,30))


        assertEquals(100, solution(0,100,1))

    }


    fun solution(X: Int, Y: Int, D: Int): Int {
        // write your code in Kotlin
        return (Y-X) / D + if (((Y-X) % D) > 0) {1} else {0}

    }
}