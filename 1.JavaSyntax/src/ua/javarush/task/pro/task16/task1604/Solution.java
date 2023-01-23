package ua.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День тижня твого народження
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1993,Calendar.APRIL,18);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишіть тут ваш код
        switch (calendar.get(Calendar.DAY_OF_WEEK)-1)
        {
            case (0):
                return "неділя";

            case (1):
                return "понеділок";

            case (2):
                return "вівторок";

            case (3):
                return "середа";

            case (4):
                return "четвер";

            case (5):
                return "п'ятниця";

            case (6):
                return "Субота";

        }

        return null;
    }
}
