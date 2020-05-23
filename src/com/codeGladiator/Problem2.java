package com.codeGladiator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {

    public static void main(String args[]){
        int[] teamMemberArray = new int[10];
        String[] inputArray = new String[3];
        List<String[]> testCases = new ArrayList<>();

        try(Scanner sc = new Scanner(System.in)){
            String testCaseString = sc.nextLine();
            int testCaseCount  = Integer.parseInt(testCaseString);
            for(int i=0;i<testCaseCount;i++){
                for(int j=0;j<3;j++){
                    inputArray[j] = sc.nextLine();
                }
                testCases.add(inputArray);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        for(int tc=0;tc<testCases.size();tc++) {
            int winCount = 0;
            inputArray = testCases.get(tc);
            int members = Integer.parseInt(inputArray[0]);
            long[] p1Object = Arrays.stream(inputArray[1].split(" "))
                    .mapToLong(s -> Long.parseLong(s))
                    .sorted()
                    .toArray();
            long[] p2Object = Arrays.stream(inputArray[2].split(" "))
                    .mapToLong(s -> Long.parseLong(s))
                    .sorted()
                    .toArray();

//        Arrays.stream(p1Object).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(p2Object).forEach(System.out::print);

            int[] nonMatchingIndex = new int[members];
            int nmi = 0;
            for (int i = 0; i < members; i++) {
                if (p2Object[i] < p1Object[i]) {
                    winCount++;
                } else {
                    nonMatchingIndex[nmi] = i;
                    nmi++;
                }
            }
            int currentIndex = 0;

            for (int i = 0; i < nmi; i++) {
                for (int j = currentIndex; j < nmi; j++) {
                    //     System.out.println("Comparing :"+p2Object[nonMatchingIndex[i]] +" and "+ p1Object[nonMatchingIndex[j]]);
                    if (p2Object[nonMatchingIndex[i]] < p1Object[nonMatchingIndex[j]]) {
                        winCount++;
                        currentIndex = nonMatchingIndex[j];
                    }
                }

            }
            System.out.println(winCount);
        }


    }

    private static List<Integer> processStringArray(String[] inputArray){
       List<Integer> convertedArray =  Arrays.asList(inputArray).stream()
                                 .map(s -> Integer.parseInt(s))
                                 .collect(Collectors.toList());
       //Arrays.stream(convertedArray).forEach( i -> System.out.print(i));
        return convertedArray;

    }
}
