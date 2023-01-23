package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bufferedReader.readLine();
        String path2 = bufferedReader.readLine();
        bufferedReader.close();
        write(path2,changer(read(path1)));
    }
    private static String read(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            if (bufferedReader.ready())
                stringBuilder.append(bufferedReader.readLine());
            while (bufferedReader.ready()) {
                stringBuilder.append('\n').append(bufferedReader.readLine());
            }

        }
        String result = stringBuilder.toString();
        return result;
    }
    private static void write(String path,String result) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write(result);
        }
    }
    private static String changer(String line)
    {


        return line.replaceAll("[.]","!");
    }
}
