package ua.javarush.task.pro.task13.task1318;

/* 
Наступний місяць, будь ласка
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
    }

    public static Month getNextMonth(Month month) {
        Month[] list = Month.values();
        int leng = list.length;
        int indexOfValue = month.ordinal();
        if (indexOfValue < (leng-1)) {
            return Month.values()[indexOfValue + 1];
        } else {
            return Month.values()[0];
        }
        //напишіть тут ваш код

    }
}
