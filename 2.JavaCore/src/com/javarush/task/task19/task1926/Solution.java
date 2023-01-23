package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 ="";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();


        }
        List<String> lines = read(file1);
        lines.forEach(x-> System.out.println(reverser(x)));



    }
    private static boolean isNoPaTH (String word)
    {

        return word.length()<=6?false:true;
    }
    private static String collector(List<String> words)
    {
        StringBuilder stringBuilder=new StringBuilder();
        words.forEach(x->stringBuilder.append(x).append(","));
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
    private static String reverser (String lines)
    {
        StringBuilder stringBuilder = new StringBuilder();


        return stringBuilder.append(lines).reverse().toString();
    }

    private static void writer(String words,String path) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write(words);
        }
    }

    private static String[] wordParser (List<String> lines)
    {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(x->stringBuilder.append(x).append(" "));
        return (stringBuilder.toString()).split(" ");
    }

    private static List<String> read(String path) throws IOException {
        List<String> allLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                allLines.add(bufferedReader.readLine());
            }
        }
        return allLines;
    }
}
