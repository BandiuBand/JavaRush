package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path1 = scanner.nextLine();
        String path2 = scanner.nextLine();
        List<Byte> byte1 = new ArrayList<>();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path1))){
            while (bufferedInputStream.available() > 0)
                byte1.add((byte) bufferedInputStream.read());
        }
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path1))){
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path2))){
                while (bufferedInputStream.available() > 0)
                {
                    bufferedOutputStream.write(bufferedInputStream.read());
                }

                for (Byte b:byte1) {
                    bufferedOutputStream.write(b);
                }
            }
        }
    }
}
