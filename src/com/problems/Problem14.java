package com.problems;

import java.util.ArrayList;

public class Problem14 {

        public static void main(String[] args) {
            int total;
            int local = 0;
            ArrayList<Long> highestList = new ArrayList<>(1000000);
            ArrayList<Long> highestNumberList = new ArrayList<>(1000000);
            //highestList.ensureCapacity(20000000);

            //System.out.println(highestList.size());

            highestList.add(0, 1l);
            highestList.add(1, 1l);
            highestNumberList.add(0,0l);
            highestNumberList.add(1,1l);

            //System.out.println(highestList.size());

            for (int i = 2; i <= 999999; i++) {
                long n = i;
                do {
                    if (n < i) {
                        if (i == 3) {
                            local = local - 1;
                        }
                        //System.out.println("local: " + local);
                        //System.out.println("i is: " + i);
                        //System.out.println("n is: " + n);
                        //System.out.println("highestlist n-1: " + highestList.get((int)(n - 1)));

                        total = local + Integer.parseInt(highestList.get((int)(n - 1)).toString());

                        highestList.add((long)total);
                        highestNumberList.add((long)i);

                        local = 0;
                        break;
                    }

                    if (n % 2 == 0) {
                        n = n / 2;
                    } else {
                        n = 3 * n + 1;
                    }
                    local++;

                } while (n != 1);
            }

            //System.out.println(highestList.size());
            //System.out.println(highestNumberList.size());

            long highest = 0l;
            long number = 0l;

            for (int i = 1; i < highestList.size(); i++){
                //System.out.println("# of hops: " + highestList.get(i));
                //System.out.println("index: " + highestNumberList.get(i - 1));
                if (highest < highestList.get(i)) {
                    highest = highestList.get(i);
                    number = highestNumberList.get(i);
                }
            }
            //System.out.println("Size is: " + highestList.size());
            System.out.println("Highest # of hops is: " + highest);
            System.out.println("Number is: " + number);
        }
    }

