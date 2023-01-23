package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String path = (new Scanner(System.in)).nextLine();
        byte max = 0;
        try (FileInputStream fileInputStream = new FileInputStream(path)){


            int maxInt = Integer.MAX_VALUE;
            while (fileInputStream.available() > 0) {
                int value  = fileInputStream.read();
                if (value < maxInt) {
                    maxInt = value;
                }


            }
            System.out.println(maxInt);
        } catch (Exception e)
        {
            throw e;
        }
    }
}
