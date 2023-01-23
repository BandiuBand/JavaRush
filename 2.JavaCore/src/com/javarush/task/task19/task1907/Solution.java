package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.Scanner;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()))){
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready())
            {stringBuilder.append(bufferedReader.readLine());
            stringBuilder.append(' ');}
            String allLines = stringBuilder.toString();
            String[] allWords = allLines.replaceAll("[\\W]"," ").split(" ");
            int counter = 0;
            for (String str:allWords) {
                if (str.equals("world"))
                    counter++;
            }
            System.out.println(counter);
        }
    }
}
