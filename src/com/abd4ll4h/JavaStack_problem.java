package com.abd4ll4h;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStack_problem {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
            System.out.println(input.isEmpty());
        }


    }

}
