
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BiggerIsGreater {

    //https://www.hackerrank.com/challenges/bigger-is-greater/problem
    //@ABD4LL4H
    static String biggerIsGreater(String s)
    {
        char charArr[] = s.toCharArray();
        int n = charArr.length,i;
        for (i = n - 1; i > 0; i--)
        {
            if (charArr[i] > charArr[i - 1])
            {
                break;
            }
        }
        if (i == 0)
        {
            return "no answer";
        }
        else
        {
            int small = charArr[i - 1], next = i;

            for (int j = i + 1; j < n; j++)
            {
                if (charArr[j] > small && charArr[j] < charArr[next])
                {
                    next = j;
                }
            }
            swap(charArr, i - 1, next);
            Arrays.sort(charArr, i , n);
        }
        return new String(charArr);
    }
    static void swap(char charArr[], int i, int j)
    {
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            System.out.println(result);
        }


        scanner.close();
    }
}
