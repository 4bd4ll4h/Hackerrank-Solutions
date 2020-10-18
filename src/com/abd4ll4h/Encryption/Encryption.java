package com.abd4ll4h.Encryption;

import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    //https://www.hackerrank.com/challenges/encryption/problem
    //@abd4ll4h

    static String encryption(String s) {

        s = s.replaceAll(" ", "");
        StringBuilder stringBuilder = new StringBuilder();

        int row = 0, column = 0;

        if (Math.floor(Math.sqrt(s.length())) * Math.floor(Math.sqrt(s.length())) >= s.length()) {
            row = (int) Math.floor(Math.sqrt(s.length()));
            column = (int) Math.floor(Math.sqrt(s.length()));
        } else if (Math.floor(Math.sqrt(s.length())) * Math.ceil(Math.sqrt(s.length())) >= s.length()) {
            row = (int) Math.floor(Math.sqrt(s.length()));
            column = (int) Math.ceil(Math.sqrt(s.length()));
        } else if (Math.ceil(Math.sqrt(s.length())) * Math.ceil(Math.sqrt(s.length())) >= s.length()) {
            row = (int) Math.ceil(Math.sqrt(s.length()));
            column = (int) Math.ceil(Math.sqrt(s.length()));
        }

        for (int i = 0; i < column; i++) {
            for (int u = i; u < row * column; u += column) {
                if (u < s.length()) {
                    stringBuilder.append(s.charAt(u));
                }
            }
            stringBuilder.append(" ");

        }
        return stringBuilder.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = encryption(s);

        System.out.println(result);


        scanner.close();
    }
}
