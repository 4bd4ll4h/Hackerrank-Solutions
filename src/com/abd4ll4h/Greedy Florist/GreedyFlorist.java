import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyFlorist {

    //https://www.hackerrank.com/challenges/greedy-florist/problem
    //@4d4ll4h
    static int getMinimumCost(int k, int[] c) {

        Arrays.sort(c);
        int size=c.length-1;
        int result=0;
        int prevP=0;
        while (size>=0){
            for(int n=0;n<k&&size>=0;n++){
                result+=(1+prevP)*c[size];
                size--;
            }
           prevP++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(String.valueOf(minimumCost));


        scanner.close();
    }
}
