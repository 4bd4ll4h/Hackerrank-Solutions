package com.abd4ll4h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class QueenAttackII {

    //https://www.hackerrank.com/challenges/queens-attack-2/problem
    //abd4ll4h

    static int queensAttack(int n, int r_q, int c_q,
                            HashMap<Integer, ArrayList<Integer>> obstaclesByRow,
                            HashMap<Integer, ArrayList<Integer>> obstaclesByColum,
                            HashMap<Integer, ArrayList<Integer>> obstaclesByDiagonals,
                            HashMap<Integer, ArrayList<Integer>> obstaclesByRevesedDiagonals) {
        //move Counter
        int count = 0;
        //count the number of left and right moves
        count += countDirction(n, r_q, c_q, obstaclesByRow);
        //count the number of up and down moves
        count += countDirction(n, c_q, r_q, obstaclesByColum);

        //count the number of Diagonals moves

        //number of moves down-left if there are no obstacles
        int downleft = r_q - 1;
        if (downleft + (n + 1 - c_q) > n) downleft = n - (n + 1 - c_q);
        //number of moves up-right if there are no obstacles
        int upRight = n - c_q;
        if (upRight + r_q > n) upRight = n - r_q;
        //loop through the obstacles to find the closest one
        if (!obstaclesByDiagonals.isEmpty()) {
            AtomicInteger minRow = new AtomicInteger(r_q);
            AtomicInteger minColumn = new AtomicInteger(c_q);
            AtomicInteger maxRow = new AtomicInteger(r_q);
            AtomicInteger maxColunm = new AtomicInteger(c_q);
            obstaclesByDiagonals.forEach((integer, integers) -> {
                if (integer < c_q && integers.get(0) < r_q && ((minColumn.get() < integer && minRow.get() < integers.get(0)) || minColumn.get() == c_q)) {
                    minColumn.set(integer);
                    minRow.set(integers.get(0));

                }
                if (integer > c_q && integers.get(0) > r_q && ((maxColunm.get() > integer && maxRow.get() > integers.get(0)) || maxColunm.get() == c_q)) {
                    maxColunm.set(integer);
                    maxRow.set(integers.get(0));

                }

            });
            if (maxRow.get() == r_q && maxColunm.get() == c_q) count += upRight;
            else count += Math.abs(maxColunm.get() - c_q - 1);
            if (minRow.get() == r_q && minRow.get() == r_q) count += downleft;
            else count += Math.abs(c_q - minColumn.get() - 1);
        } else count += upRight + downleft;


        //count the number of the other Diagonals moves

        //number of moves down-right moves if there are no obstacles
        int downRight = n - (n + 1 - r_q);
        if (downRight + c_q > n) downRight = n - c_q;
        //number of moves up-left moves if there are no obstacles
        int upleft = n - (n + 1 - c_q);
        if (upleft + r_q > n) upleft = n - r_q;
        if (!obstaclesByRevesedDiagonals.isEmpty()) {
            AtomicInteger minRow = new AtomicInteger(r_q);
            AtomicInteger minColumn = new AtomicInteger(c_q);
            AtomicInteger maxRow = new AtomicInteger(r_q);
            AtomicInteger maxColunm = new AtomicInteger(c_q);
            obstaclesByRevesedDiagonals.forEach((integer, integers) -> {
                if (integer > c_q && integers.get(0) < r_q && ((minColumn.get() > integer && minRow.get() < integers.get(0)) || minColumn.get() == c_q)) {
                    minColumn.set(integer);
                    minRow.set(integers.get(0));

                }
                if (integer < c_q && integers.get(0) > r_q && ((maxColunm.get() < integer && maxRow.get() > integers.get(0)) || maxColunm.get() == c_q)) {
                    maxColunm.set(integer);
                    maxRow.set(integers.get(0));

                }

            });
            if (maxRow.get() == r_q && maxColunm.get() == c_q) count += upleft;
            else count += Math.abs(maxRow.get() - r_q - 1);
            if (minColumn.get() == r_q && minRow.get() == r_q) count += downRight;
            else count += Math.abs(r_q - minRow.get() - 1);
        } else count += upleft + downRight;

        return count;

    }

    //function to compute the number of moves for the right-left-up-down moves
    private static int countDirction(int n, int r_q, int c_q, HashMap<Integer, ArrayList<Integer>> obstacles) {
        int count = 0;
        if (obstacles.containsKey(r_q)) {
            ArrayList<Integer> row = obstacles.get(r_q);
            int min = 0, max = n + 1;
            for (Integer i : row) {
                if (i > min && i < c_q) min = i;
                if (i < max && i > c_q) max = i;
            }
            count += Math.abs(max - c_q - 1);
            count += Math.abs(c_q - 1 - min);

        } else count += n - 1;
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);


        // hashMap contain the obstacles that face the queen
        HashMap<Integer, ArrayList<Integer>> obstaclesByRow = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> obstaclesByColum = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> obstaclesByDiagonals = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> obstaclesByRevesedDiagonals = new HashMap<>();


        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int row = Integer.parseInt(obstaclesRowItems[0]);
            int column = Integer.parseInt(obstaclesRowItems[1]);

            //storing obstacles that in the same row with the queen
            ArrayList<Integer> Row;
            if (r_q == row) {
                Row = new ArrayList<>();
                Row.add(column);
                if (obstaclesByRow.get(row) != null)
                    Row.addAll(obstaclesByRow.get(row));
                obstaclesByRow.put(row, Row);

            }

            //Storing obstacles that in the same column with the queen
            ArrayList<Integer> Cloumn;
            if (column == c_q) {
                Cloumn = new ArrayList<>();
                Cloumn.add(row);
                if (obstaclesByColum.get(column) != null)
                    Cloumn.addAll(obstaclesByColum.get(column));
                obstaclesByColum.put(column, Cloumn);


            }
            //Storing obstacles the in same diagonals with the queen
            ArrayList<Integer> dio;
            if (Math.abs(row - r_q) == Math.abs(column - c_q) && ((row > r_q && column > c_q) || (row < r_q && column < c_q))) {
                dio = new ArrayList<>();
                dio.add(row);
                obstaclesByDiagonals.put(column, dio);
            }
            //Storing obstacles the in same other diagonals with the queen
            ArrayList<Integer> Rdio;
            if (Math.abs(r_q - row) == Math.abs(c_q - column) && ((row > r_q && column < c_q) || (row < r_q && column > c_q))) {
                Rdio = new ArrayList<>();
                Rdio.add(row);
                obstaclesByRevesedDiagonals.put(column, Rdio);
            }


        }

        int result = queensAttack(n, r_q, c_q, obstaclesByRow, obstaclesByColum, obstaclesByDiagonals, obstaclesByRevesedDiagonals);


        System.out.println(result);
        scanner.close();
    }
}
