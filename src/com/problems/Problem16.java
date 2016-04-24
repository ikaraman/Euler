package com.problems;

import java.math.BigInteger;

public class Problem16 {

        public static void main (String[] args) {
            BigInteger number = new BigInteger(String.valueOf(2));

            System.out.println("Original number is: " + number);
            number = number.pow(1000);
            System.out.println("number in ^1000 is: " + number);

            String strNumber = number.toString();
            //System.out.println(strNumber);
        }
    }

