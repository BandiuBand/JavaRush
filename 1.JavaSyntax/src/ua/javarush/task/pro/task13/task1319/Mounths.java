package ua.javarush.task.pro.task13.task1319;

public class Mounths {
    public static void main(String[] args) {
        Month[]  m = Month.getWinterMonths();

        System.out.println(m[0]);
        Month[]  m1 = Month.getSpringMonths();

        System.out.println(m1[0]);
        Month[]  m2 = Month.getSummerMonths();

        System.out.println(m2[0]);
        Month[]  m3 = Month.getAutumnMonths();

        System.out.println(m3[0]);
    }
}
