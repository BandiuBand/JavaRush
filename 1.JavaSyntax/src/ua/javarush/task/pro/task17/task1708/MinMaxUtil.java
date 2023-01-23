package ua.javarush.task.pro.task17.task1708;

/*
Мінімальне й максимальне
*/

public class MinMaxUtil {
    public static int min(int value1, int value2) {
        return Math.min(value1, value2);
    }

    public static int min(int value1, int value2, int value3) {
        return min(value3, min(value1, value2));
    }

    public static int min(int value1, int value2, int value3, int value4) {
        return min(value4, min(value1, value2, value3));
    }

    public static int min(int value1, int value2, int value3, int value4, int value5) {
        return min(value5, min(value1, value2, value3, value4));
    }

    public static int max(int value1, int value2) {
        return Math.max(value1, value2);
    }

    public static int max(int value1, int value2, int value3) {
        return max(value3, max(value1, value2));
    }

    public static int max(int value1, int value2, int value3, int value4) {
        return max(value4, max(value1, value2, value3));
    }

    public static int max(int value1, int value2, int value3, int value4, int value5) {
        return max(value5, max(value1, value2, value3, value4));
    }
}
