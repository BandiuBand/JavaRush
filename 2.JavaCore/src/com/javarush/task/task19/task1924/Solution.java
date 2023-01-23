package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.*;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
        static {
            map.put(0,"ноль");
            map.put(1,"один");
            map.put(2,"два");
            map.put(3,"три");
            map.put(4,"четыре");
            map.put(5,"пять");
            map.put(6,"шесть");
            map.put(7,"семь");
            map.put(8,"восемь");
            map.put(9,"девять");
            map.put(10,"десять");
            map.put(11,"одиннадцать");
            map.put(12,"двенадцать");
        }

        public static void main(String[] args) throws IOException {


            String file1 ="";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                file1 = reader.readLine();


            }


            List<String> lines = read(file1);
            List<String> retLines = new ArrayList<>();
            lines.forEach(x->retLines.add(collector(comparator(wordParser(x)))));

            System.out.println(collectorLast(retLines));

        }
        private static String rerurnWord (String word)
        {
            String s;
            for (int i = 0; i < 13; i++) {
            if (word.equals(String.valueOf(i))) {
                return map.get(i);
            } else {
                s = checkPunct(word);
                if (s!=null)
                    return s;
            }
        }
            return word;
        }
        private static String checkPunct (String word)
        {String s;
            for (int i = 0; i < 13; i++) {
                int u = word.length()-1;
                char o = word.charAt(u);
                String p = String.valueOf(o);
                if ((String.valueOf(i).equals(s = word.replace(p,"")))&& p.matches("\\p{Punct}"))
                    return map.get(i) + p;

            }
            return null;
        }
        private static String collector(List<String> words)
        {
            StringBuilder stringBuilder=new StringBuilder();
            words.forEach(x->stringBuilder.append(x).append(" "));
            return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
        }

    private static String collectorLast(List<String> words)
    {
        StringBuilder stringBuilder=new StringBuilder();
        words.forEach(x->stringBuilder.append(x).append("\n"));
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
        private static List<String> comparator (String[] words)
        {
            List<String> wordsRet = new ArrayList<>();
            Arrays.stream(words).forEach(x->{
                wordsRet.add(rerurnWord(x));});
            return wordsRet;
        }


        private static void writer(String words,String path) throws IOException {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
                bufferedWriter.write(words);
            }
        }

        private static String[] wordParser (String line)
        {

            return (line.toString()).split(" ");
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
        private static String[] pathReader()
        {
            String[] file = new String[2];
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                file[0] = reader.readLine();
                file[1] = reader.readLine();

            } catch (IOException ignore) {
                /* NOP */
            }
            return file;
        }
}
