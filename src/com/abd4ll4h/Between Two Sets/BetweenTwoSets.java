
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BetweenTwoSets {

    //https://www.hackerrank.com/challenges/between-two-sets/problem
    //@abd4ll4h

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        // array of results
        ArrayList<Integer>factors=new ArrayList<>();

        for(int i=Collections.max(a);i<=Collections.min(b);i++){
            int finalI = i;
            // check to see if i is a LCM in all array a and GCD in all array b
            if(a.stream().allMatch(integer ->  finalI %integer==0)&&b.stream().allMatch(integer -> integer%finalI==0))
                factors.add(i);
        }

        return factors.size();
    }



        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int total = BetweenTwoSets.getTotalX(arr, brr);

            System.out.println(String.valueOf(total));

            bufferedReader.close();

        }
    }
