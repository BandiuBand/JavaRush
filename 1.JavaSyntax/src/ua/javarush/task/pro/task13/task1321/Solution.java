package ua.javarush.task.pro.task13.task1321;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getTranslationForDayOfWeek("Вівторок"));
        System.out.println(getTranslationForDayOfWeek("П'ятниця"));
        System.out.println(getTranslationForDayOfWeek("Нічогонеділя"));
    }

    public static String getTranslationForDayOfWeek(String ua) {
        String en;
        if ("понеділок".equals(ua.toLowerCase())) {
            en = "Monday";
        } else if ("вівторок".equals(ua.toLowerCase())) {
            en = "Tuesday";
        } else if ("середа".equals(ua.toLowerCase())) {
            en = "Wednesday";
        } else if ("четвер".equals(ua.toLowerCase())) {
            en = "Thursday";
        } else if ("п'ятниця".equals(ua.toLowerCase())) {
            en = "Friday";
        } else if ("субота".equals(ua.toLowerCase())) {
            en = "Saturday";
        } else if ("неділя".equals(ua.toLowerCase())) {
            en = "Sunday";
        } else {
            en = "Неприпустимий день тижня";
        }
        return en;

    }
}
