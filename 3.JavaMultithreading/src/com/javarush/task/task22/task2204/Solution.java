package com.javarush.task.task22.task2204;

/* 
Форматирование строки
*/

public class Solution {
    public static void main(String[] args) {
        double d1 = (20.0 / 7.0);
        double d2 =(10.0 / 3.0);
        System.out.println(String.format(getFormattedString(), d1, d2));
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = %.2f%nExp = %.2e";
    }
}
