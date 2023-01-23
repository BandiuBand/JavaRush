package ua.javarush.task.pro.task15.task1510;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Пишемо байти у файл
*/

public class Solution {
public static void main(String[] args) throws IOException {
        byte[] bytes = args[0].getBytes();
        Scanner scanner = new Scanner(System.in);
        Files.write(Path.of(scanner.nextLine()), bytes);
        }
        }

