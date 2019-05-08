package com.samuelbeck.codilitytests;


import org.junit.Test;


/*
 * Created by samueljbeck on 2/20/19.
 */
public class IterationJava {

    @Test
    public void iterationTest() {
        System.out.println(getZerosCountInInteger(65));

        System.out.println(getZerosCountInInteger(-65));

        System.out.println(getZerosCountInInteger(0));

        System.out.println(getZerosCountInInteger(654648505));



    }

    private Integer getZerosCountInInteger(Integer input) {
        int binaryLen = 32;
        if (input > 0) {
            binaryLen = Integer.toBinaryString(input * -1).length();
        } else if (binaryLen < 0) {
            binaryLen = Integer.toBinaryString(input).length();
        } else {
            return binaryLen;
        }

        String binary = String.format("%" + binaryLen + "s", Integer.toBinaryString(input)).replace(" ", "0");

        for(int i = 1; i <= binaryLen; i++) {
            String zeros = new String(new char[i]).replace("\0", "0");
            if (!binary.contains(zeros)) {
                return i - 1;
            }
        }

        return 0;

    }


}
