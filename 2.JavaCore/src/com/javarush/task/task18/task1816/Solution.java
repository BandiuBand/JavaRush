package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        long count = 0;
        if (args == null) {
            return;
        }
      //  File f = new File(args[0]);
      //  if (!f.exists())
       // return;
        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(args[0])) ){
            while (bufferedReader.ready())
            {
                int b = (int) bufferedReader.read();
                if ((96 < b &&  b < 123)||(64 < b &&  b < 91)) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }
}
