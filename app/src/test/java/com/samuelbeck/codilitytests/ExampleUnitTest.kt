package com.samuelbeck.codilitytests

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(3, jumpingOnClouds(arrayOf(0,0,0,1,0,0)))


    }


    fun sockMerchant(n: Int, ar: Array<Int>): Int {
        val originals = ArrayList<Int>()
        var count = 0
        ar.forEach{
            if (originals.contains(it)) {
                originals.remove(it)
                count++
            } else {
                originals.add(it)
            }
        }
        return count

    }


    fun countingValleys(n: Int, s: String): Int {

        var elevation = 0
        var valleys = 0

        s.forEach {
            if (it.equals('D')) {
                if (elevation == 0)
                    valleys++
                elevation--
            } else {
                elevation++
            }
        }
        return valleys
    }


    // Complete the jumpingOnClouds function below.
    fun jumpingOnClouds(c: Array<Int>): Int {
        var count = 0
        var current = 0
        for(i in c.indices) {
            if (i == current && i < c.size - 1) {
                if ((i + 2) < c.size && c[i + 2].equals(0)) {
                    current = i + 2
                } else {
                    current = i + 1
                }
                count++
            }
        }
        return count
    }

    // Complete the repeatedString function below.
    fun repeatedString(s: String, n: Long): Long {
        var sCount = 0 // count of as in s
        val repeatCount = n / s.length
        val remainder = n % s.length
        var rCount = 0

        s.forEach{
            if (it.equals('a'))
                    sCount++
        }

        s.take(remainder.toInt()).forEach {
            if (it.equals('a'))
                rCount++
        }

        return (sCount * repeatCount) + rCount




    }
}

