package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String eE;
        List<FileInputStream> is = new ArrayList<>();
        Scanner k = new Scanner(System.in);
        try {
        while (true)
        {String l = k.nextLine();
            try (FileInputStream fileInputStream =new FileInputStream(l)){
                is.add(fileInputStream);
            } catch (FileNotFoundException e) {
                //System.out.println(l);
                throw new FileNotFoundException(l);
            }
        }} catch (FileNotFoundException e)
        {
            eE= String.valueOf(e);
        } catch (IOException e1)
        {
            throw new RuntimeException();
        }
        System.out.println(eE.substring(eE.indexOf(" ")+1,eE.length()));
    }
}
