package ua.javarush.task.pro.task14.task1414;

/* 
Готуємо коктейлі
*/

import java.util.ArrayList;

public class Solution {

    public static final String OUTPUT_FORMAT = "Метод %s викликано з рядка %d класу %s у файлі %s.\n";

    public static void main(String[] args) {
        makeScrewdriver();
    }

    public static void printStackTrace(StackTraceElement[] stackTrace) {
        //напишіть тут ваш код
        for (StackTraceElement stTr : stackTrace) {
           String string = String.valueOf(stTr);
            int tochki = string.lastIndexOf(':');
            int openBracket = string.lastIndexOf('(');
            int closeBracet = string.lastIndexOf(')');
            String file = string.substring(openBracket+1,tochki);
            String namberStr = string.substring(tochki+1,closeBracet);
            string = string.substring(0,openBracket);
            int tochkaOfMetod = string.lastIndexOf('.');
            String metod = string.substring(tochkaOfMetod+1,string.length());
            String clas = string.substring(0,tochkaOfMetod);
            String result = "Метод " + metod + " викликано з рядка " + namberStr + " класу " + clas + " у файлі " + file + '.';
            //Метод addJuice викликано з рядка 24 класу com.javarush.task.pro.task14.task1414.Solution у файлі Solution.java.



           // System.out.println(stTr);
            System.out.println(result);

        }
    }

    static void makeScrewdriver() {
        addJuice();
    }

    static void addJuice() {
        addVodka();
    }

    static void addVodka() {
        printStackTrace(Thread.currentThread().getStackTrace());
    }
}
