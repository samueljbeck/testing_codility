package com.samuelbeck.codilitytests

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/*
 * Created by samueljbeck on 2/21/19.
 *
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

fun solution(A: IntArray, K: Int): IntArray

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
class CyclicRotation {

    @Test
    fun cyclicRotationTest() {
        val orig = intArrayOf(3, 8, 9, 7, 6)
        val final = intArrayOf(9, 7, 6, 3, 8)

        assertTrue(final.contentEquals(solution(orig, 3)))
        assertTrue(intArrayOf().contentEquals(solution(intArrayOf(), 25)))
    }


    fun solution(A: IntArray, K: Int): IntArray {
        // write your code in Kotlin

        var shift = K
        if (A.size.equals(K) || A.isEmpty()) {
            return A
        } else if (A.size < K) {
            shift = K % A.size
        }

        return A.takeLast(shift).toIntArray() + A.take(A.size - shift).toIntArray()

    }
}