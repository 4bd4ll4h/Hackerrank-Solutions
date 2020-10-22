import java.io.IOException;
import java.util.*;

public class AbsolutePermutation {
    //https://www.hackerrank.com/challenges/absolute-permutation/problem
    //@abd4lll4h
    static Integer[] absolutePermutation(int n, int k) {

        if (n <= k )
            return new Integer[]{-1};


        Set<Integer> numbers = new LinkedHashSet<>();
        //spacial case
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                numbers.add(i + 1);
            }
            return numbers.toArray(new Integer[0]);
        }


        for(int i=0;i<n;i++){
            //counter from 1
            int tempI = i + 1;
            // pos[i]-i=k
            int x = Math.abs(tempI - k);
            //i-pos[i]=k
            int y = k + tempI;
            boolean validX=false,validY=false;
            if(x>0&&Math.abs(x-tempI)==k&&x<=n)validX=true;
            if(y>0&&Math.abs(y-tempI)==k&&y<=n)validY=true;

            //to check if the set changed
            int size=numbers.size();

           if(validY&&validX){
               //chose the small value
               numbers.add(x>y?y:x);
               if(numbers.size()>size)continue;
               else numbers.add(x>y?x:y);
           }
           // if there are only one value that is valid ? chose that value
           if(validX&&!validY){
               numbers.add(x);
               if(numbers.size()>size)continue;
               else break;
           }
           if(!validX&&validY){
               numbers.add(y);
               if(numbers.size()>size)continue;
               else break;
           }
           if(numbers.size()!=i+1)break;
        }

        //if the size of the set is (n) that mean all Permutation has been added with no duplicates so print the set
        // if false print -1
        return numbers.size()==n?numbers.toArray(new Integer[0]):new Integer[]{-1};

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            Integer[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }


        scanner.close();
    }
}