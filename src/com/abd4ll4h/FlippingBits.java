package com.abd4ll4h;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/flipping-bits/problem
public class FlippingBits {
    static long flippingBits(long n) {
        String b= (Long.toBinaryString(n));

        while (b.length()<32){
            b="0"+b;
        }
        b=b.replace("0","2");
        b=b.replace("1","0");
        b=b.replace("2","1");
        return Long.parseLong(b,2);



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

/* test case
3
0
802743475
35601423
*/
