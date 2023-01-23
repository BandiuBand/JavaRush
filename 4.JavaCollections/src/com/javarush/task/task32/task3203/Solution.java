package com.javarush.task.task32.task3203;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* 
Пишем стек-трейс
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) throws FileNotFoundException {
        StringWriter stringWriter = new StringWriter();
        String result = new String("");
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);


        return stringWriter.toString();
    }
}
