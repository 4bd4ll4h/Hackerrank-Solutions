package com.abd4ll4h;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//https://www.hackerrank.com/challenges/jim-and-the-orders/problem
public class Jim_and_the_Orders {
    static int[] jimOrders(int[][] orders) {
        Integer[][]ord=new Integer[orders.length/2][3];
        for (int i=0;i<orders.length;i++){
            ord[i][0]=orders[i][0];
            ord[i][1]=orders[i][1];
            ord[i][2]=i+1;

        }
        Arrays.sort(ord, Comparator.comparingInt(o -> o[0] + o[1]));
        int[]res=new int[orders.length/2];
        for(int i=0;i<orders.length/2;i++){
            res[i]=ord[i][2];
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            try {
                bufferedWriter.write(String.valueOf(result[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
