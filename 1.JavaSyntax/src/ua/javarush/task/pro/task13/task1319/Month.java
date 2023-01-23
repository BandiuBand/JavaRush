package ua.javarush.task.pro.task13.task1319;

/* 
Місяці в порах року
*/

import java.util.Arrays;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
        public static Month[] getWinterMonths()
        {
            Month[] winter = new Month[3];
            winter[0] = Month.DECEMBER;
            winter[1] = Month.JANUARY;
            winter[2] = Month.FEBRUARY;
           return winter;
        }
        public static Month[] getSpringMonths()
        {

            return getPoraRoku(2,5);
        }
        public static Month[] getSummerMonths()
        {
            return getPoraRoku(5,8);
        }
        public static Month[] getAutumnMonths()
        {
            return getPoraRoku(8,11);
        }
    //напишіть тут ваш код
    private static Month[] getPoraRoku(int start,int finish)
    {
        Month[] list = Month.values();
        return Arrays.copyOfRange(list, start, finish);
    }

}
