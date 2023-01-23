package ua.javarush.task.pro.task16.task1607;

import java.time.LocalDate;
import java.time.Month;

/* 
Опанування нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
//        LocalDate q = LocalDate.of(2020, Month.SEPTEMBER,12);
//        LocalDate w = LocalDate.of(1970,1,1);
//        System.out.println(q.getDayOfYear());
//        System.out.println(q.toEpochDay());
    }

    static LocalDate nowExample() {
        //напишіть тут ваш код

        return LocalDate.now();
    }

    static LocalDate ofExample() {
        //напишіть тут ваш код

        return LocalDate.of(2020, Month.SEPTEMBER,12);
    }

    static LocalDate ofYearDayExample() {
        //напишіть тут ваш код


        return LocalDate.ofYearDay(2020,256);
    }

    static LocalDate ofEpochDayExample() {
        //напишіть тут ваш код

        return LocalDate.ofEpochDay(18517);
    }
}
