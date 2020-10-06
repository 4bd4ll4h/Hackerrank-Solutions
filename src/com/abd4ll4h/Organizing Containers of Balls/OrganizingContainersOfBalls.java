import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls{

//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
    //@4bd4ll4h
    private static final Scanner scanner = new Scanner(System.in);

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int aa=in.nextInt();
        for(int iii=0;iii<aa;iii++){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    int x = in.nextInt();
                    a[i] += x;
                    b[j] += x;
                }
            }
            String pts = "Possible";
            for(int i=0;i<n;i++)
            {
                int j=0;
                for(j=i;j<n;j++)
                {
                    if(a[i] == b[j])
                    {
                        int temp = b[j];
                        b[j] = b[i];
                        b[i] = temp;
                        break;
                    }
                }
                if(j==n)
                {
                    pts = "Impossible";
                    break;
                }
            }
            System.out.println(pts);
        }}

}