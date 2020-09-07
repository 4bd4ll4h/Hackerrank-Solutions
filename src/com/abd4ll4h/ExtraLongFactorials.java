package com.abd4ll4h;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    //@4bd4ll4h
   // https://www.hackerrank.com/challenges/extra-long-factorials/problem
    static void extraLongFactorials(int n) {

        System.out.println(multiP(n));


    }
    static String multiP(int n){

        if (n == 1) {
            return String.valueOf(n);
        }else {
            BigInteger bigInteger = new BigInteger(String.valueOf(n));
            return bigInteger.multiply(new BigInteger(multiP(n-1))).toString();

        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
