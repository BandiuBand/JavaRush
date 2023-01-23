package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> allBytes= new TreeSet<>();
        try (FileInputStream fileInputStream= new FileInputStream(new Scanner(System.in).nextLine())) {
            while (fileInputStream.available() > 0)
            {
                allBytes.add(fileInputStream.read());
            }
        }
        StringBuilder stringBuilder= new StringBuilder();
        allBytes.forEach(x->stringBuilder.append(x).append(" "));
        String result = stringBuilder.toString();
        System.out.println(result.substring(0,result.length()-1));
    }
}
