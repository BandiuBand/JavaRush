package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.String.valueOf;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        try
        {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader =new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String buf = bufferedReader.readLine();
            StringBuilder k = new StringBuilder();
            while (buf != null){
            k.append(buf);
            buf = bufferedReader.readLine();
            if(buf != null)
            k.append("\n");}
            System.out.println(k.toString());
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}