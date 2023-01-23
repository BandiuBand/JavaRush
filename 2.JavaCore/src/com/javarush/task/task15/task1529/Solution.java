package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() {
        String read;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            read = bufferedReader.readLine();
            try {


            if (read.equals("helicopter"))
                result = (CanFly) new Helicopter();
            else if (read.equals("plane"))
            {
               int readInt = Integer.parseInt(bufferedReader.readLine());
                result = (CanFly) new Plane(readInt);
            }}
            catch (Exception e)
            {
                System.out.println(e);
                throw e;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //add your code here - добавьте код тут

    }
    static {
        reset();
    }
}
