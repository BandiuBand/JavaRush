//package com.javarush.task.task19.task1922;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Ищем нужные строки
//*/
//
//public class Solution {
//    public static List<String> words = new ArrayList<String>();
//
//    static {
//        words.add("file");
//        words.add("view");
//        words.add("B");
//    }
//
//    public static void main(String[] args) throws IOException {
//        List<String> lines = read(readPath());
//        for (String line:lines) {
//            if (isContainTw(line,words))
//                System.out.println(line);
//        }
//    }
//    private static boolean isContainTw (String line,List<String> wordS)
//    {int counter = 0;
//        for (String word:wordS) {
//
//                counter+=havMachContain(line,word);
//        }
//        return counter==2?true:false;
//    }
//    private static int havMachContain(String line,String word)
//    {   String[] wordS = line.split(" ");
//        int counter=0;
//        for (String w:wordS) {
//            if (w.contains(word))
//                counter++;
//        }
//        return counter;
//    }
//    private static String readPath() throws IOException {
//        String path;
//
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            path = bufferedReader.readLine();
//        }
//        return path;
//    }
//
//    private static List<String> read(String path) throws IOException {
//        List<String> allLines = new ArrayList<>();
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
//            while (bufferedReader.ready()) {
//                allLines.add(bufferedReader.readLine());
//            }
//        }
//        return allLines;
//    }
//}
package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String file1 = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();

        } catch (IOException ignore) {
            /* NOP */
        }

        try (BufferedReader in = new BufferedReader(new FileReader(file1))) {
            while (in.ready()) {
                String readedString = in.readLine();
                String[] splitedReadedString = readedString.split(" ");

                int wordCount = 0;
                for (String s : splitedReadedString) {
                    if (words.contains(s)) {
                        wordCount++;
                    }
                }

                if (wordCount == 2)
                    System.out.println(readedString);
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
