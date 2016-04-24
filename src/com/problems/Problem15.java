package com.problems;

public class Problem15 {

        public static void main (String[] args) {
            int n = 20; //dimensions
            System.out.println(routes(n));
        }

        public static long routes(int n) {
            //idea is:
            //quantity of routes in [n*n] = 2*[n-1*n]
            //quantity of routes in [n-1*n] = [n-2*n] + [n-1*n-1]

            long [][] list = new long[n][n];
            list[0][0] = 2;

            for (int j = 1; j < n; j++) {
                list[0][j] = list[0][j-1] + 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if ( i == j ) {
                        list[i][j] = 2*list[i-1][j];
                    } else {
                        list[i][j] = list[i][j-1] + list[i-1][j];
                    }
                }
            }

            return list[n-1][n-1];
        }
    }
