package com.samuelbeck.codilitytests

import org.junit.Assert.assertEquals
import org.junit.Test

/*
 * Created by samueljbeck on 2/25/19.
 *
 * forgot to check for null and empty strings
 */


class Toptal1 {

    @Test
    fun toptal1Test() {

        assertEquals(solution("nice", "niece"), "INSERT e")
        assertEquals(solution("ack", "jack"), "INSERT j")
        assertEquals(solution("jac", "jack"), "INSERT k")

        assertEquals(solution("test", "tent"), "REPLACE s n")
        assertEquals(solution("facebook", "lacebook"), "REPLACE f l")
        assertEquals(solution("facebook", "faceboos"), "REPLACE k s")

        assertEquals(solution("form", "from"), "SWAP o r")




    }

    fun solution(S: String, T: String): String {
        // write your code in Kotlin
        when {
            insert(S,T) != null  -> return "INSERT " + insert(S,T)
            equal(S,T) -> return "EQUAL"
            replace(S,T) != null -> return "REPLACE " + replace(S,T)
            swap(S,T) != null  -> return "SWAP " + swap(S,T)
        }
        return "IMPOSSIBLE"
    }


    fun insert(S: String, T: String): String? {
        if (S.length == T.length - 1) {
            for (i in 1..T.length) {
                if (i == 1) {
                    if (T.takeLast(T.length - 1).equals(S)) {
                        return T.take(1)
                    }
                } else if (i == S.length) {
                    if (T.take(T.length - 1).equals(S)) {
                        return T.takeLast(1)
                    }
                } else {
                    val testString = T.take(i) + T.takeLast(T.length - i - 1)
                    if (testString.equals(S)) {
                        return T.take(i + 1).takeLast(1)
                    }

                }

            }
        }
        return null
    }

    fun replace(S: String, T: String): String? {
        if (S.length == T.length) {
            for (i in 1..T.length) {
                if (i == 1) {
                    if (T.takeLast(T.length - 1).equals(S.takeLast(S.length - 1))) {
                        return S.take(1) + " " + T.take(1)
                    }
                } else if (i == S.length) {
                    if (T.take(T.length - 1).equals(S.take(S.length - 1))) {
                        return S.takeLast(1) + " " + T.takeLast(1)
                    }
                } else {
                    val testStringS = S.take(i -1) + S.takeLast(S.length - i)
                    val testStringT = T.take(i -1) + T.takeLast(T.length - i)
                    if (testStringS.equals(testStringT)) {
                        return S.take(i).takeLast(1) + " " + T.take(i).takeLast(1)
                    }

                }

            }
        }


        return null
    }

    fun swap(S: String, T: String): String? {
        if (S.length == T.length) {
            for (i in 1..T.length) {
                if (i == 1) {
                    if (T.takeLast(T.length - 2).equals(S.takeLast(S.length - 2)) &&
                                T.take(2).equals(S.take(2).takeLast(1) + S.take(1))) {
                        return S.take(1) + " " + T.take(2).takeLast(1)
                    }
                } else if (i == S.length) {
                    if (T.take(T.length - 2).equals(S.take(S.length - 2)) &&
                            T.takeLast(2).equals(S.takeLast(1) + S.takeLast(2).take(1))) {
                        return S.takeLast(1) + " " + S.takeLast(2).take(1)
                    }
                } else {
                    val testStringS = S.take(i -1) + S.takeLast(S.length - i - 1)
                    val testStringT = T.take(i -1) + T.takeLast(T.length - i - 1)

                    val testSwapT = T.take(i + 1).takeLast(2)
                    val testSwapS = S.take(i + 1).takeLast(1) + S.take(i ).takeLast(1)
                    if (testStringS.equals(testStringT) &&
                       testSwapT.equals(testSwapS)) {
                        return S.take(i).takeLast(1)  + " " +  S.take(i + 1).takeLast(1)
                    }

                }

            }
        }

        return null
    }

    fun equal(S: String, T: String) : Boolean {
        if (S.equals(T)) {
            return true
        }
        return false
    }


}