//package com.javarush.task.task22.task2202;
//
///*
//Найти подстроку
//*/
//
//public class Solution {
//    public static void main(String[] args) {
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//    }
//
//    public static String getPartOfString(String string) {
//        try {
//
//
//            String first_subsrting = string.substring(string.indexOf(" ")+1);
//
//            int index_of_4 = findInsex(string);
//            int fiend_endOfWord = first_subsrting.indexOf(" ", index_of_4);
//            if (fiend_endOfWord <= 0)
//                fiend_endOfWord = first_subsrting.length();
//            String second_substring = first_subsrting.substring(0, fiend_endOfWord);
//            return second_substring;
//        }
//        catch (Exception e)
//        {
//            throw new TooShortStringException();
//        }
//
//    }
//    private static int findInsex (String string)
//    {
//        int index = 0;
//        for (int i = 0; i < 4; i++) {
//            index = string.indexOf(" ",index)+1;
//            if (index == 0)
//                throw new TooShortStringException();
//        }
//        return index-1;
//    }
//
//    public static class TooShortStringException extends RuntimeException{
//    }
//}
package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splitWithSpaces = string.split(" ");

        if (splitWithSpaces.length < 5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(splitWithSpaces[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
