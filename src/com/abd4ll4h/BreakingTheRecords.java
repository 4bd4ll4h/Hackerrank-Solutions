package com.abd4ll4h;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BreakingTheRecords {
//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
    //@4bd4ll4h
    static int[] breakingRecords(int[] scores) {
        int[] resulte = new int[2];
        resulte[0] = 0;
        resulte[1] = 0;
        int tempMin, tempMax;
            tempMin = scores[0];
            tempMax = scores[0];

        for (int i = 0; i < scores.length; i++) {
            if (tempMax < scores[i]) {
                tempMax = scores[i];
                resulte[0]++;
            }
            if (tempMin > scores[i]) {
                tempMin = scores[i];
                resulte[1]++;
            }
        }

        return resulte;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
