package com.problems.Problem13;

import com.problems.Problem11.FileReader;

import java.math.BigInteger;

public class Problem13 {
    public static void main(String[] args) {

        //read the file
        String pathToFile = "C:/Users/ikaraman/IdeaProjects/Euler/src/com/problems/Problem13/fileToRead.txt";
        String file;
        file = FileReader.readAndReturn(pathToFile);
        System.out.println("File is: " + file);

        //create placeholder array for 50-digits numbers
        BigInteger [] sums = new BigInteger[100];
        String number = "";
        int n = 0;

        //loop to save all numbers to array
        for ( int i = 0; i < file.length(); i++){
            number = number + String.valueOf(file.charAt(i));

            //if space found, record number & proceed further
            if ( i+1 < file.length() && Character.getNumericValue(file.charAt(i+1)) == -1 && n < 100 ) {
                    sums[n] = new BigInteger(number);
                    number = "";
                    n++;
                    i++;
                }
            }

        //add all numbers from the array to each other
        BigInteger total = BigInteger.valueOf(0);
        for (int i = 0; i < sums.length; i++) {
            total = total.add(sums[i]);
        }
        System.out.println("Sum of all 50-digits numbers is: " + total);
        String temp = total.toString();

        //read first 10 digits from the sum
        String temp2 = "";
        for (int i = 0; i < 10; i++) {
            temp2 = temp2 + String.valueOf(temp.charAt(i));
        }
        System.out.println("First 10 digits of the sum is: " + temp2);
    }
}


