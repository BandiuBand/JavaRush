package ua.javarush.task.pro.task15.task1505;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Чомусь не копіюється…
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
            int size = 1024;
            byte[] buffer = new byte[size+1];
            while (inputStream.available() > 0) {
                int read = inputStream.read(buffer);
                outputStream.write(buffer, 0, read);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}