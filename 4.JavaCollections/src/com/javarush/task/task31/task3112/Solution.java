package com.javarush.task.task31.task3112;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("c:\\2\\"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
        Path target = Paths.get(downloadDirectory.toString() + "/" + fileName);
        Path  tmp = Files.createTempFile("temp",".txt");
        InputStream inputStream= url.openStream();
        Files.copy(inputStream,tmp,StandardCopyOption.REPLACE_EXISTING);
        Files.move(tmp,target,StandardCopyOption.REPLACE_EXISTING);

        return target;
    }
}
