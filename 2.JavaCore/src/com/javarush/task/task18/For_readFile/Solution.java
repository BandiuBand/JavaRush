package com.javarush.task.task18.For_readFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        System.out.println("Введіть шлях до файлу");
        try (FileInputStream fileInputStream =
                     new FileInputStream(
                             new Scanner(
                                     System.in)
                                     .nextLine()))
        {
            while (fileInputStream.available() > 0)
                list.add(fileInputStream.read());
        } catch (Exception e)
        {
            System.out.println("Щось пішло не так");
        }
        System.out.println(list);
    }
}