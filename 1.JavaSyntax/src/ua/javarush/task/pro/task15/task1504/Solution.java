package ua.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Переплутані байти
*/

public class Solution {
    public static void main(String[] args) {
        //напишіть тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
            boolean flag = false;
            int size = 1;
            int buf=0;
            byte[] buffer = new byte[size];
            while (inputStream.available() > 0) {
                int read = inputStream.read();
                if (inputStream.available() > 0)
                {
                    int read2 = inputStream.read();
                    outputStream.write(read2);
                    outputStream.write(read);
                }
                else
                {
                    outputStream.write(read);
                }

            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
            int size = 1024;
            byte[] buffer = new byte[size];
            while (inputStream.available() > 0) {
                int read = inputStream.read();
                outputStream.write(buffer, size, read);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}*/
