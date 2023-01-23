package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;
        String number = telNumber;
        int countNumbers = 10;
        if (number.length() > 15 || number.length() < 10)
        return false;
        String ch = telNumber.substring(telNumber.length()-1);
        if (ch.matches("\\D"))
            return false;
        if (telNumber.startsWith("+")) {
            countNumbers = 12;
            number = number.substring(1);
        }
        number = number.replaceAll("\\(\\d{3}\\)","000");
//        System.out.println();
//        String pattern = "\\D+";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(number);
//        boolean f = m.matches();
        if (number.matches(".*\\D+.*"))
            return false;
        if (number.length()!=countNumbers)
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.print("+380501234567");
        System.out.println(checkTelNumber("+380501234567"));
        System.out.print("+38(050)1234567");
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.print("(050)1234567");
        System.out.println(checkTelNumber("(050)1234567"));
        System.out.print("0(501)234567");
        System.out.println(checkTelNumber("0(501)234567"));
        System.out.print("+38)050(1234567");
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.print("+38(050)123-45-67");
        System.out.println(checkTelNumber("+38(050)123-45-67"));
        System.out.print("050ххх4567");
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.print("050123456");
        System.out.println(checkTelNumber("050123456"));
        System.out.print("(0)501234567");
        System.out.println(checkTelNumber("(0)501234567"));
        System.out.print("+380501234(567)");
        System.out.println(checkTelNumber("+380501234(567)"));

    }
}
