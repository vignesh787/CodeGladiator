package com.codeGladiator;

import java.util.*;

public class Problem1 {

    public static void main(String args[]){
        String[] inputArray  = new String[4];
        long max = Long.MAX_VALUE;
        long arrayLen = 0;
        try(Scanner sc = new Scanner(System.in)){
            for(int i=0;i<3;i++) {
                inputArray[i] = sc.nextLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            arrayLen = Integer.parseInt(inputArray[0].trim());

            String[] q1 = inputArray[1].split(" ");
            long[] intq1 = Arrays.stream(q1).map(s -> Long.parseLong(s))
                    .mapToLong(i -> i).toArray();
            String[] q2 = inputArray[2].split(" ");
            long[] intq2 = Arrays.stream(q2).map(s -> Long.parseLong(s))
                    .mapToLong(i -> i).toArray();

        for(int i=0;i<arrayLen;i++){
            long rem  = intq2[i]/intq1[i];
            if(rem < max){
                max = rem;
            }
        }
        }catch(NumberFormatException nfe){
            System.out.println(0);
            return;
        }
        System.out.println(max);
    }
}
