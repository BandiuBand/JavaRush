package ua.javarush.task.pro.task12.task1205;

/* 
Метод ділення
*/


public class Solution {

    static double ebsilon = 0.00000000000000000000000000000000000000000000000000000000000000000001;

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        //напишіть тут ваш код
        if (
                        (checkZero(a) && checkZero(b)) ||
                        (a == Double.POSITIVE_INFINITY && b == Double.POSITIVE_INFINITY) ||
                        (a == Double.POSITIVE_INFINITY && b == Double.NEGATIVE_INFINITY) ||
                        (a == Double.NEGATIVE_INFINITY && b == Double.POSITIVE_INFINITY) ||
                        (a == Double.NEGATIVE_INFINITY && b == Double.NEGATIVE_INFINITY) ||
                        (a == Double.NaN || b == Double.NaN)
        )
        {
            System.out.println(Double.NaN);
        return;
        }
        else if (
                        (a > 0 && checkZero(b)) ||
                        (a == Double.POSITIVE_INFINITY && b != Double.POSITIVE_INFINITY && (b > 0 || checkZero(b))) ||
                        (a == Double.NEGATIVE_INFINITY && b != Double.NEGATIVE_INFINITY && b < 0 )
        )
        {
            System.out.println(Double.POSITIVE_INFINITY);
            return;
        }
        else if (
                        (a < 0 && checkZero(b)) ||
                        (a == Double.NEGATIVE_INFINITY && (b > 0 || checkZero(b)) && b != Double.POSITIVE_INFINITY) ||
                        (a == Double.POSITIVE_INFINITY && b < 0 && b != Double.NEGATIVE_INFINITY)
        )
        {
            System.out.println(Double.NEGATIVE_INFINITY);
            return;
        }
        else
        {
            System.out.println(a / b);
        }

    }
    static boolean checkZero(double number)
    {
       return ((number > 0) && (number < ebsilon));
    }
}
