import java.io.IOException;
import java.util.Scanner;

public class TheGridSearch {

    //https://www.hackerrank.com/challenges/the-grid-search/problem
    //@4bd4ll4h
    static String gridSearch(String[] G, String[] P) {

        String pFirstLine = P[0], result = "NO";

        int lenRow = P.length;

        for (int i = 0; i < G.length; i++) {
            if (result.equals("YES")) break;
            if (G[i].contains(pFirstLine) && i + lenRow - 1 < G.length) {
                for (int n = -1; (n = G[i].indexOf(pFirstLine, n + 1)) != -1; n++) {
                    if (result.equals("YES")) break;
                    int rowCounter = 1;
                    for (int y = i + 1; y <= lenRow - 1 + i; y++) {
                        if (G[y].contains(P[rowCounter]) && G[y].indexOf(P[rowCounter], n) == n) {
                            rowCounter++;
                            result = "YES";
                        } else {
                            result = "NO";
                            break;
                        }

                    }
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            System.out.println(result);

        }


        scanner.close();
    }

}