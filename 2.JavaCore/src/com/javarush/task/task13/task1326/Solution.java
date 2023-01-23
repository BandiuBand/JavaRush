package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/




public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
     try (BufferedReader bufferedReader =
     new BufferedReader(new InputStreamReader(new FileInputStream(path))))
     {
         String nextLin;
         ArrayList<Integer> list= new ArrayList<>();
         while ((nextLin = bufferedReader.readLine()) != null)
         
         {
             list.add(Integer.parseInt(nextLin));
         }
         list.stream().filter((x)->(x % 2 == 0)).sorted().forEach((x) -> System.out.println(x));
     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
    }
}
