package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    private static String TooShortStringException;

    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null)
            throw new TooShortStringException();
        String[] words = string.split("\\t");
        if (words.length<3)
            throw new TooShortStringException();
        return words[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush -\t лучший сервис \tобучения Java\t."));

    }
}
