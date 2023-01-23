package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String[] uuu = getTokens("level22.lesson13.task01", ".");
        Arrays.stream(uuu).forEach(System.out::println);
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query , delimiter);
        List<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens())
        {
            list.add(stringTokenizer.nextToken());
        }
        String[] strings = list.stream()
                .toArray(String[]::new);
        return strings ;
    }
}
