package ua.javarush.task.pro.task15.task1522;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/* 
Отримання інформації через API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.com.ua/api/1.0/rest/projects");
        //напишіть тут ваш код
        try {
            InputStream input = url.openStream();
            BufferedReader  bufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder k = new StringBuilder();
            String str;
            while ((str=bufferedReader.readLine())!=null)
            {
            k.append(str).append(System.lineSeparator());
            }
            System.out.println(k.toString());
            input.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}