package com.abd4ll4h;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class BigDecimal_problem {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add((s[i]));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new BigDecimal(o1).compareTo(new BigDecimal(o2));
            }
        }.reversed());
        list.toArray(s);
       /* Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new BigDecimal(o1).compareTo(new BigDecimal(o2));;
            }
        }));
        */
        for (String  bigDecimal:list){
            System.out.println(bigDecimal);
        }
    }

    }
