//package com.javarush.task.task32.task3210;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.io.Reader;
//import java.util.Arrays;
//
///*
//Используем RandomAccessFile
//*/
//
//public class Solution {
//    public static void main(String... args) throws IOException {
//        String fileName = args[0];
//        long number = Long.parseLong(args[1]);
//        String text = args[2];
//        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName,"rw");
//        int lents = text.length();
//        byte[] bytes = new byte[lents];
//        randomAccessFile.seek(number);
//        try {
//        randomAccessFile.read(bytes);}
//        catch (Exception e)
//        {
//            randomAccessFile.seek(randomAccessFile.length()+1);
//            randomAccessFile.writeBytes("false");
//            return;
//        }
//        String readText = new String(bytes);
//        randomAccessFile.seek(randomAccessFile.length()+1);
//        if (readText.equals(text))
//
//            randomAccessFile.writeBytes("true");
//
//        else
//            randomAccessFile.writeBytes("false");
//    }
//}
package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);
            String text = args[2];
            long fileLength = raf.length();

            raf.seek(number);
            byte[] readBytes = new byte[text.length()];
            raf.read(readBytes, 0, text.length());

            String readString = new String(readBytes);

            raf.seek(fileLength);
            if (readString.equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}