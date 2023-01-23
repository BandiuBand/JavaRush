package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bufferedReader.readLine();
        String path2 = bufferedReader.readLine();
        bufferedReader.close();
        write(path2,divider(read(path1)));
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
        private static String divider(String line)
        {
            String[] allSpleated = line.split(" ");
            Stream<String> result = Arrays.stream(allSpleated).filter(x->x.matches("[-+]?\\d+"));

            StringBuilder stringBuilder = new StringBuilder();
            result.forEach(x->stringBuilder.append(x).append(' '));
            stringBuilder.deleteCharAt((stringBuilder.length()-1));


            return stringBuilder.toString();
        }
}
