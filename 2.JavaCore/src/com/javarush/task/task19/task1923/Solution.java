package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> lines = read(args[0]);
        writer(collector(comparator(wordParser(lines))),args[1]);

    }
    private static boolean isHaveNumber (String word)
    {   for (int i = 0; i < 10; i++) {
            if (word.contains(String.valueOf(i)))
                return true;
        }
        return false;
    }
    private static String collector(List<String> words)
    {
        StringBuilder stringBuilder=new StringBuilder();
        words.forEach(x->stringBuilder.append(x).append(" "));
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
    private static List<String> comparator (String[] words)
    {
        List<String> wordsHaveNumber = new ArrayList<>();
        Arrays.stream(words).forEach(x->{if (isHaveNumber(x))
        wordsHaveNumber.add(x);});
        return wordsHaveNumber;
    }

    private static void writer(String words,String path) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write(words);
        }
    }

    private static String[] wordParser (List<String> lines)
    {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(x->stringBuilder.append(x));
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