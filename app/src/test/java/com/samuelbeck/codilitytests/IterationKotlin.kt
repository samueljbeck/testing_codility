package com.samuelbeck.codilitytests


import org.junit.Test

import org.junit.Assert.*

/*
 * Created by samueljbeck on 2/20/19.
 */
class IterationKotlin {

    @Test
    fun iterationTest() {

        var x = Integer.toBinaryString(65)

        println(solution(65))

        println(solution(-65))


        println(solution(0))

        println(solution(654648505))

        assertEquals(solution(65), 5)



    }

    private fun getZerosCountInInteger(input: Int): Int {
        var binaryLen = Integer.toBinaryString(-1).length
        if (input > 0) {
            binaryLen = Integer.toBinaryString(input * -1).length
        } else if (binaryLen < 0) {
            binaryLen = Integer.toBinaryString(input).length
        } else {
            return 32
        }

        val binary = Integer.toBinaryString(input).padStart(binaryLen, '0')

        for (count in 1..binaryLen) {
            if (!binary.contains("0".repeat(count))) {
                return count - 1
            }
        }

        return 0
    }

    fun solution(N: Int): Int {
        // write your code in Kotlin
        val binary = Integer.toBinaryString(N).trim('0') // this will eliminate leading zeros

        for (count in 1..binary.length) {
            if (!binary.contains("0".repeat(count))) {
                return count - 1
            }
        }

        return 0


    }
}