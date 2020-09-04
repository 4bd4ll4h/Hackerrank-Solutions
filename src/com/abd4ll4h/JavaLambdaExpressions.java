package com.abd4ll4h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaLambdaExpressions {

    interface PerformOperation {
        boolean check(int a);
    }

    static class MyMath {
        public static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        private PerformOperation isOdd() {
            return a -> (a % 2 != 0);
        }


        private PerformOperation isPrime() {
            return a -> isPrimev(a);
        }

        boolean isPrimev(int num) {
            if (num < 2)
                return false;
            // Check for even numbers
            if (num % 2 == 0) {
                return num == 2;
            }
            // Check for odd numbers
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }

        private PerformOperation isPalindrome() {
            return a -> {
                String num = String.valueOf(a);
                return num.equals(new StringBuilder(Integer.toString(a)).reverse().toString());
            };
        }

        // Write your code here
        public static void main(String[] args) throws IOException {
            MyMath ob = new MyMath();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            PerformOperation op;
            boolean ret = false;
            String ans = null;
            short a =9;
            System.out.println(a+9);
            while (T-- > 0) {
                String s = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int ch = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                if (ch == 1) {
                    op = ob.isOdd();
                    ret = ob.checker(op, num);
                    ans = (ret) ? "ODD" : "EVEN";
                } else if (ch == 2) {
                    op = ob.isPrime();
                    ret = ob.checker(op, num);
                    ans = (ret) ? "PRIME" : "COMPOSITE";
                } else if (ch == 3) {
                    op = ob.isPalindrome();
                    ret = ob.checker(op, num);
                    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

                }
                System.out.println(ans);
            }
        }


    }

}
