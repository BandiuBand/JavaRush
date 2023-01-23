package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readString;
        while (!(readString = reader.readLine()).equals("exit")) {
            new ReadThread(readString).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            byte[] bytesCount = new byte[256];
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                while (fileInputStream.available() > 0) {
                    int aByte = fileInputStream.read();
                    bytesCount[aByte]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            int maxCount = 0;
            int maxCountByte = 0;
            for (int i = 0; i < bytesCount.length; i++) {
                if (bytesCount[i] > maxCount) {
                    maxCount = bytesCount[i];
                    maxCountByte = i;
                }
            }
            resultMap.put(fileName, maxCountByte);
        }
    }
}



//package com.javarush.task.task18.task1823;

//import java.io.*;
//import java.util.*;
//
///*
//Нити и байты
//*/
//
//public class Solution {
//    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
//
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        String path;
//        while (!(path = s.nextLine()).equals("exit"))
//        {
//            new ReadThread(path).start();
//        }
//        System.out.println(resultMap);
//
//    }
//
//    public static class ReadThread extends Thread {
//        private String fileName;
//        private Integer maxMeatByte;
//        public ReadThread(String fileName) {
//            //implement constructor body
//            this.fileName = fileName;
//                   }
//        @Override
//        public void run()
//        {
//            List<Integer> bytes = null;
//            try {
//                bytes = reader(fileName);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            maxMeatByte = fingMaxMeat(bytes);
//            setMaxMeat();
//        }
//
//        private Integer fingMaxMeat(List<Integer> bytes) {
//            SortedMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return  o2 -  o1;
//                }
//            });
//            for (Integer b:bytes) {
//                if (map.get(b) == null)
//                    map.put(b,1);
//                else map.put(b,(map.get(b)+1));
//            }
//            return map.firstKey();
//        }
//
//
//        private List<Integer> reader(String fileName) throws IOException {
//            List<Integer> allBytes = new ArrayList<>();
//            try (FileInputStream fS = new FileInputStream(fileName)){
//                while (fS.available()>0)
//                    allBytes.add( fS.read());
//            }
//            return allBytes;
//        }
//
//        private void setMaxMeat()
//        {
//            synchronized (resultMap)
//            {resultMap.put(fileName,maxMeatByte);}
//        }
//        // implement file reading here - реализуйте чтение из файла тут
//    }
//}
