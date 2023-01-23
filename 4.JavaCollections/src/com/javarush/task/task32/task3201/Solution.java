package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName,"rw");
        if (randomAccessFile.length()<number)
            randomAccessFile.seek(randomAccessFile.length());
        else
            randomAccessFile.seek(number);
        for (int i = 0; i < text.length(); i++) {
            randomAccessFile.write(text.charAt(i));
        }

        randomAccessFile.close();



    }
}
