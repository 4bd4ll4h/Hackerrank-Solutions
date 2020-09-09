package com.abd4ll4h;

import java.util.Scanner;

public class NonDivisibleSubset {
    //@4bd4ll4h
    //https://www.hackerrank.com/challenges/non-divisible-subset/problem


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int count = 0;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int b[] = new int[k + 1];

        for (int i = 0; i < n; i++) {
            b[a[i] % k] = b[a[i] % k] + 1;
        }
        int cond = (k % 2 == 0) ? k / 2 : (k / 2) + 1;
        for (int j = 0; j < cond; j++) {
            if (b[0] != 0 && j == 0)
                count++;
            else
                count += (b[j] > b[k - j]) ? b[j] : b[k - j];
        }
        if (k % 2 == 0)
            count += 1;
        System.out.println(count);

        in.close();
    }
}



