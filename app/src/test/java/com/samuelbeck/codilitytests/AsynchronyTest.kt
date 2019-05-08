package com.samuelbeck.codilitytests

/*
 * Created by samueljbeck on 4/21/19.
 */
import android.provider.Settings
import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Pattern.matches

/*
 * Created by samueljbeck on 2/20/19.
 *
 *



 */
class AsynchronyTest {

    @Test
    fun replacementTest() {

        Settings.Global.launch {
            de
        }

        System.out.println(encode("Hello World!"))
        assertEquals("g2kk4yv4qkc!", encode("Hello World!"))
        assertEquals(
            " 45'u2ym2u2qyg21qcy4eysg2yl3kk2mm35lye1kb4m?y3s'rysg2yrg3oysg1syl1c2ysg2yj2rr2kyq5my3myk2rrysg1my21yo1qr2br.",
            encode("You've never heard of the Millennium Falcon? It's the ship that made the Kessel Run in less than 12 parsecs.")
        )
        assertEquals("sg2y4m2yeq4lysg2yu3kk1f2,yem7812", encode("The one from the village, FN2187"))
        assertEquals("g2y1rj2cye4qy1y31ya5sysg2 ycq2vy1y13", encode("He asked for a 13 but they drew a 31"))

    }
    // Complete the encode function below.
    fun encode(stringToEncode: String): String {
        var returnString = ""

        var numberToEvaluate = "" //numbers are replaced with their reverse: 1 -> 1, 23 -> 32, 1234 -> 4321

        for(letter in stringToEncode) {

            //check for numbers
            if (letter.isDigit()) {
                numberToEvaluate += letter
                continue
            } else if (numberToEvaluate.isNotEmpty()) {
                returnString += numberToEvaluate.reversed()
                numberToEvaluate = ""
            }

            if (letter.isLetter()) {
                returnString +=
                    when (letter.toString().toLowerCase()) {
                        //vowels are replaced with number: a -> 1, e -> 2, i -> 3, o -> 4, and u -> 5
                        "a" -> 1
                        "e" -> 2
                        "i" -> 3
                        "o" -> 4
                        "u" -> 5
                        //y is replaced with space
                        "y" -> ' '
                        else -> {
                            //consonants are replaced with previous letter: b -> a, c -> b, d -> c, etc.
                            letter.dec()
                        }
                    }
            } else {
                //other characters remain unchanged (punctuation, etc.)

                //space is replaced with y
                returnString += if (letter == ' ') 'y' else letter
            }
        }

        //all output should be lower case, regardless of input case ("Hello World" should produce the same result as "hello world")
        returnString += numberToEvaluate.reversed()
        return returnString.toLowerCase()
    }
}