package com.samuelbeck.codilitytests

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
 * Created by samueljbeck on 2/20/19.
 *
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.

 */
class OddIntegerArray {

    @Test
    fun oddIntegerArrayTest() {
        val origin = ArrayList<Int>()
        for (coun in 1..999990) {
            origin.addAll(intArrayOf(9, 3, 9, 3, 9, 7, 9).toCollection(ArrayList()))
        }
        origin.add(6)

        var startTime = Calendar.getInstance().timeInMillis
        //assertEquals(6, solutionA(origin.toIntArray()))  //times out
        var endTime = Calendar.getInstance().timeInMillis
        var time = endTime - startTime
        //println(time)

        startTime = Calendar.getInstance().timeInMillis
        //assertEquals(6, solutionB(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        //println(time)

        startTime = Calendar.getInstance().timeInMillis
        assertEquals(6, solutionC(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        println(time)

        startTime = Calendar.getInstance().timeInMillis
        //assertEquals(6, solutionD(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        //println(time)

        startTime = Calendar.getInstance().timeInMillis
        assertEquals(6, solutionE(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        println(time)

        startTime = Calendar.getInstance().timeInMillis
        assertEquals(6, solutionF(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        println(time)

        startTime = Calendar.getInstance().timeInMillis
        assertEquals(6, solutionG(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        println(time)

        startTime = Calendar.getInstance().timeInMillis
        assertEquals(6, solutionH(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        println(time)

        startTime = Calendar.getInstance().timeInMillis
        assertEquals(6, solutionI(origin.toIntArray()))
        endTime = Calendar.getInstance().timeInMillis
        time = endTime - startTime
        println(time)
    }

    fun solutionA(A: IntArray): Int {
        // write your code in Java SE 8
        val s = A.toList() as java.util.ArrayList

        for (value in A) {
            if (s.contains(value)) {
                s.remove(value)
                if (s.contains(value)) {
                    s.remove(value)
                } else {
                    return value
                }
            }
        }

        return 0
    }

    fun solutionB(A: IntArray): Int {
        // write your code in Java SE 8
        val s = A.toList() as java.util.ArrayList

        do {
            val value = s[0]
            s.remove(value)
            if (s.contains(value)) {
                s.remove(value)
            } else {
                return value
            }
        } while (s.size > 0)

        return 0
    }

    fun solutionC(A: IntArray): Int {
        // write your code in Java SE 8

        var tested = ArrayList<Int>()
        for (value in A) {
            if (!tested.contains(value) && A.count { e -> value == e } % 2 != 0) {
                return value
            } else {
                tested.add(value)
            }
        }

        return 0
    }

    fun solutionD(A: IntArray): Int {
        // write your code in Java SE 8

        A.map { value ->
            if (A.count { e -> value == e } % 2 != 0) {
                return value
            }
        }
        return 0
    }

    fun solutionE(A: IntArray): Int {
        // write your code in Java SE 8

        var uniques = HashMap<Int, Int>()

        for (value in A) {
            if (uniques.contains(value)) {
                uniques[value] = uniques[value]!! + 1
            } else {
                uniques[value] = 1
            }
        }
        for (value in uniques.keys) {
            if (uniques[value]!! % 2 != 0) {
                return value
            }
        }

        return 0
    }

    fun solutionF(A: IntArray): Int {
        // write your code in Java SE 8

        val uniques = ArrayList<Int>()
        val counts = ArrayList<Int>()

        for (value in A) {
            if (uniques.contains(value)) {
                counts[uniques.indexOf(value)] = counts[uniques.indexOf(value)] + 1
            } else {
                uniques.add(value)
                counts.add(1)
            }
        }


        for (value in uniques) {
            if (counts[uniques.indexOf(value)] % 2 != 0)
            return value
        }

        return 0
    }

    fun solutionG(A: IntArray): Int {
        // write your code in Java SE 8

        val map = mutableMapOf<Int, Int>()

        for (i in 0..(A.count() - 1)) {
            if (map.contains(A[i])) {
                map[A[i]] = map[A[i]]!! + 1
            } else {
                map[A[i]] = 1
            }
        }


        for (value in map.keys) {
            if (map[value]!! % 2 != 0)
                return value
        }

        return 0
    }

    fun solutionH(A: IntArray): Int {
        // write your code in Java SE 8

        val unique = A.distinct()

        for (value in unique) {
            if (A.count { e -> value == e } % 2 != 0)
                return value
        }

        return 0
    }

    fun solutionI(A: IntArray): Int {  //fastest solution Who would have thunk it?  Tried everything else.
        // write your code in Java SE 8

        var solution = 0

        for (value in A)
            solution = solution xor value

        return solution
    }
}