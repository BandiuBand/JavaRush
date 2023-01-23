package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split(".part");
                String[] parts2 = o2.split(".part");
                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
                return number1 - number2;
            }
        });
        String outputFile = null;
        String readString;
        while (!(readString = reader.readLine()).equals("end")) {
            files.add(readString);
            if (outputFile == null) {
                int indexOfSuffix = readString.lastIndexOf(".part");
                outputFile = readString.substring(0, indexOfSuffix);
            }
        }
        if (outputFile == null) return;
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}


//package com.javarush.task.task18.task1825;
//
//import java.io.*;
//import java.util.*;
//
//Собираем файл
//
//
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        SortedMap<Integer,String> map = parseNumber(readPaches());
//        writeF(collectors(map),getFileNameOut(map.get(map.firstKey())));
//    }
//
//
//
//    private static String getFileNameOut(String pach)
//    {   String filePach;
//        filePach = pach.substring(0,pach.indexOf(".part"));
//        return filePach;
//    }
//    private static void writeF (List<Byte> bytes , String pach) throws IOException {
//        try (BufferedOutputStream bOS = new BufferedOutputStream(new FileOutputStream(pach))){
//            int i = 0;
//            int count = 0;
//            byte[] buf = new byte[256];
//            while (i < bytes.size())
//            {
//                if (count < 255) {
//                    buf[count] = bytes.get(i);
//                    count++;
//                    i++;
//                }
//                else
//                {
//                    bOS.write(buf);
//                    count = 0;
//                }
//            }
//            if (count!=0)
//                bOS.write(buf,0,count+1);
//
//        }
//    }
//
//
//    private static List<Byte> collectors(SortedMap<Integer,String> map) throws IOException {
//           List<Byte> bytes = new ArrayList<>();
//           for(Map.Entry entry:map.entrySet())
//            {
//                String pach = (String) entry.getValue();
//
//                try (BufferedInputStream bIS = new BufferedInputStream(new FileInputStream(pach))){
//                    while (bIS.available() > 0)
//                    {
//                        byte[] b = new byte[256];
//                        int buf = bIS.read(b);
//                        for (int i = 0; i < buf; i++) {
//                            bytes.add((Byte)b[i]);
//                        }
//                    }
//                }
//            }
//            return bytes;
//        }
//
//    private static int getNumber(String pach)
//        {
//            int number = 0;
//            int index = pach.indexOf("part");
//            number = Integer.parseInt(pach.substring(index+4,pach.length()));
//            return number;
//        }
//
//    private static SortedMap<Integer,String> parseNumber (List<String> paches)
//    {
//        SortedMap<Integer,String> map = new TreeMap<>();
//        for (int i = 0; i < paches.size(); i++) {
//            int number = getNumber(paches.get(i));
//            map.put(number,paches.get(i));
//        }
//    return map;
//    }
//
//
//    private static List<String> readPaches()
//    {
//        List<String> list = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        String scanLine;
//        while (!(scanLine = scanner.nextLine()).equals("end"))
//        {
//            list.add(scanLine);
//        }
//        return list;
//    }
//}
