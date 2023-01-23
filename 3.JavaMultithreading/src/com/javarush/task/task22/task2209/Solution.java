//package com.javarush.task.task22.task2209;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;
//
///*
//Составить цепочку слов
//*/
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        //...
//        StringBuilder stringBuilder = new StringBuilder();
//        String path;
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
//        {
//            path = bufferedReader.readLine();
//        }
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
//            String line;
//            while ((line=bufferedReader.readLine())!=null)
//            {
//                stringBuilder.append(line);
//            }
//        }
//        String[] words = getWords(stringBuilder.toString()  );
//        StringBuilder result = getLine(words);
//        System.out.println(result.toString());
//    }
//
//    private static String[] getWords (String allLines)
//    {
//        return allLines.split(" ");
//    }
//    public static StringBuilder getLine(String... words) {
//        StringBuilder stringBuilder = new StringBuilder();
//        List<String> wordsList= new ArrayList<>();
//        for (String s:words) {
//            wordsList.add(s);
//        }
//
//        String curentPatient = wordsList.get(0);
//        wordsList.remove(curentPatient);
//        stringBuilder.append(curentPatient).append(" ");
//        while (true)
//        {
//            if (wordsList.size()<1)
//                break;
//            String pairForCurrent = getPair(wordsList,curentPatient);
//            stringBuilder.append(pairForCurrent).append(" ");
//            wordsList.remove(pairForCurrent);
//            curentPatient = pairForCurrent;
//        }
//        return stringBuilder.deleteCharAt(stringBuilder.length()-1);
//    }
//    private static String getPair (List<String> words,String currentWord)
//    {   if (currentWord.equals(""))
//        return "";
//        char lastCharCurrentWord = currentWord.toLowerCase().charAt(currentWord.length()-1);
//        for (String word: words) {
//            if (lastCharCurrentWord == getFirstCharAtWord(word))
//                return word;
//        }
//        return "";
//    }
//    private static char getFirstCharAtWord(String word)
//    {
//        return word.toLowerCase().charAt(0);
//    }
//}
package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException ignored) {
        }

        List<String> resultList = new ArrayList<>();
        for (String line : list) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                resultList.add(tokenizer.nextToken());
            }
        }

        StringBuilder result = getLine(getWords(resultList));
        System.out.println(result.toString());
    }

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    private static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    private static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }

}
