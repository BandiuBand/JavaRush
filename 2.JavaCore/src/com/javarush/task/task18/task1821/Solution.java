package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] aSCII = new int[128];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        }
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
        }
    }
}

//package com.javarush.task.task18.task1821;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
///*
//Встречаемость символов
//*/
//
//public class Solution {
//    private static SortedMap<Character,Integer> map = new TreeMap<>(new Comparator<Character>() {
//        @Override
//        public int compare(Character o1, Character o2) {
//            return (int)o1-(int)o2;
//        }
//    });
//    public static void main(String[] args) throws IOException {
//
//        if (args == null)
//            return;
//        String path = args[0];
//        addChracterToMap(readFile(path));
//        printList();
//
//    }
//    private static ArrayList<Character> readFile(String path) throws IOException {
//        ArrayList<Character> characters = new ArrayList<>();
//        try (FileReader fileReader = new FileReader(path)){
//            while (fileReader.ready())
//                characters.add((char) fileReader.read());
//        }
//        return characters;
//    }
//    private static void addChracterToMap (ArrayList<Character> characters)
//    {
//        for (Character c:characters) {
//           if (map.get(c) == null)
//               map.put(c,1);
//           else {
//               //int v = map.get(c)+1;
//               map.put(c,(map.get(c)+1));
//           }
//
//        }
//
//    }
//
//    private static void printList ()
//    {
//        for (Map.Entry entry: map.entrySet()) {
//            System.out.printf("%c %d",entry.getKey(),/*(int)((char)entry.getKey()),*/entry.getValue());
//            System.out.println();
//
//
//        }
//    }
//
//}
