package ua.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Тимчасове збереження файлу
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //напишіть тут ваш код
        try {


            URL url = new URL(line);
            InputStream input = url.openStream();
            byte[] buffer = input.readAllBytes();
            Path temp = Files.createTempFile(null, null);
            //OutputStream output = Files.newOutputStream(temp);
            Files.write(temp,buffer);
            input.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}