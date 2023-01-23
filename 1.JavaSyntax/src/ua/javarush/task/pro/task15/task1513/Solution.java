package ua.javarush.task.pro.task15.task1513;

import java.nio.file.Path;
import java.util.Scanner;

/*
Дивися в корінь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Path.of(str).getRoot();
        System.out.println(path);
    }
}