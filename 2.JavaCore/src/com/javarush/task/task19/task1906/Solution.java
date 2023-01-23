package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        try (FileReader fileReader = new FileReader(fileName1)) {
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            for (int i = 1; i < list.size(); i = i + 2) {
                fileWriter.write((byte) (int) list.get(i));
            }
        }
    }
}



//package com.javarush.task.task19.task1906;
//
//import java.io.*;
//import java.util.ArrayList;
//
///*
//Четные символы
//*/
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String path1 = bufferedReader.readLine();
//        String path2 = bufferedReader.readLine();
//        bufferedReader.close();
//        write(path2,divider(read(path1)));
//
//    }
//
//    private static String read(String path) throws IOException {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
//            if (bufferedReader.ready())
//                stringBuilder.append(bufferedReader.readLine());
//            while (bufferedReader.ready())
//            {
//                stringBuilder.append('\n').append(bufferedReader.readLine());
//            }
//
//        }
//        String result = stringBuilder.toString();
//        return result;
//    }
//    private static void write(String path,String result) throws IOException {
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
//            bufferedWriter.write(result);
//        }
//    }
//    private static String divider(String line)
//    {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < line.length(); i=i+2) {
//            stringBuilder.append(line.charAt(i));
//        }
//        return stringBuilder.toString();
//    }
//}
