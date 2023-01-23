package ua.javarush.task.pro.task15.task1501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Скорочуємо try
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));)
        {

            String line = reader.readLine();
            System.out.println(line.toLowerCase());
           // reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
