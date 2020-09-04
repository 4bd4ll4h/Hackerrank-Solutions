package com.abd4ll4h;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

import static java.lang.System.in;

public class PrimeChecker_problem {
    static class Prime
    {

static  String reslute="";
static ArrayList<Integer> brev=new ArrayList<>();
        public void checkPrime(Integer ... n) {
            if(brev.isEmpty()){
                if (isPrime(n[0])) {
                    reslute = reslute + n[0] + " ";
                }

            }
            else {
                for (int i=brev.size();i<n.length;i++){
                    if (isPrime(n[i])) {
                        reslute = reslute + n[i] + " ";
                    }
                }
            }
            System.out.println(reslute );
            brev=new ArrayList<Integer>(Arrays.asList(n));


        }
        boolean isPrime(int num){
            if(num<2)
                return false;
            // Check for even numbers
            if (num % 2 == 0) {
                return num == 2;
            }
            // Check for odd numbers
            for (int i = 3; i*i <= num; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
