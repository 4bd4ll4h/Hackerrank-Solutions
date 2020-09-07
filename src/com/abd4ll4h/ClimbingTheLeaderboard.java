package com.abd4ll4h;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {
   // https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int n = scores.length;
        int m = alice.length;

        int res[] = new int[m];
        int[] rank = new int[n];

        rank[0] = 1;

        for (int i = 1; i < n; i++) {
            if (scores[i] == scores[i - 1]) {
                rank[i] = rank[i - 1];
            } else {
                rank[i] = rank[i - 1] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int aliceScore = alice[i];
            if (aliceScore > scores[0]) {
                res[i] = 1;
            } else if (aliceScore < scores[n - 1]) {
                res[i] = rank[n - 1] + 1;
            } else {
                int index = binarySearch(scores, aliceScore);
                res[i] = rank[index];

            }
        }
        return res;

    }

    private static int binarySearch(int[] a, int key) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            } else
                if (a[mid] < key && key < a[mid - 1]) {
                return mid;
            } else
                if (a[mid] > key && key >= a[mid + 1]) {
                return mid + 1;
            } else
                if (a[mid] < key) {
                hi = mid - 1;
            } else
                if (a[mid] > key) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
