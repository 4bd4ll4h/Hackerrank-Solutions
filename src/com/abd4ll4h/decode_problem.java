package com.abd4ll4h;

import java.util.*;

public class decode_problem {
    static HashSet hashSet;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int res=0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast((Integer)num);
            if(deque.size()>=m){
                int first= (int) deque.getFirst();
                if(deque.size()>m) {
                    first= (int) deque.removeFirst();


                }
                int r=unique_count((ArrayDeque) deque,first);
                if(r>res)res=r;
            }

            if(res>=m)break;
        }
        System.out.println(res);

    }

    public static int unique_count(ArrayDeque list ,int first){
        if (hashSet==null) {
            hashSet= new HashSet<>(list);
            return hashSet.size();
        }
        else {
            if (!list.contains(first)) hashSet.remove(first);
            hashSet.add(list.getLast());
            return hashSet.size();
        }

    }
}
