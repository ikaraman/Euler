package com.problems;

import java.math.BigInteger;

public class Problem12 {
    public static void main(String[] args) {
        //-------объявляем константы------
        int n = 0;
        int i = 0;
        //--------------------------------
        long t1 = System.currentTimeMillis();
        while (i < 350){
            int number = triangleNumber.calculate(n);
            System.out.println(number + " <- triang. number");
            i = triangleNumber.numberOfDivisors(number);
            System.out.println(i + " <- divisors quantity");
            n++;
        }
        long t2 = System.currentTimeMillis();
        long t = t2 - t1;
        System.out.println(t/1000 + " <- seconds, time of calculation");

    }
}

class triangleNumber{
    public static int calculate(int n){
        //n(n+1)/2
        int number;
        if (n % 2 == 0) {
            number = (n/2)*(n+1);
        } else {
            number = n*((n+1)/2);
        }
        return number;
    }
    public static int numberOfDivisors(int n){
        int divisorsQuantity = 0;
        for (int i = 1; i <= n/2;i++){
            if (n % i == 0) {
                divisorsQuantity++;
            }
        }
        divisorsQuantity++;
        if(n == 0){
            divisorsQuantity = 0;
        }
        if (n == 1){
            divisorsQuantity = 1;
        }
        return divisorsQuantity;
    }

}
