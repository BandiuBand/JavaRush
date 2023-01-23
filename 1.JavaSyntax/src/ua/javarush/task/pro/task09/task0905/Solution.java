package ua.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Вісімковий конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десяткове число " + decimalNumber + " дорівнює вісімковому числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Вісімкове число " + octalNumber + " дорівнює десятковому числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        if (decimalNumber <= 0)
            return 0;
        int octNumber = 0;
        int decNumber = decimalNumber;
        int i = 0;
        while (decNumber > 0)
        {
                octNumber += decNumber%8 * (int)Math.pow(10,i);
                i++;
                decNumber/=8;

        }
        //напишіть тут ваш код
        return octNumber;
    }

    public static int toDecimal(int octalNumber) {
        //напишіть тут ваш код
        if (octalNumber <= 0)
            return 0;
        int octalNumbers = octalNumber;
        int decNumber = 0;
        int i = 0;
        while (octalNumbers > 0)
        {
            decNumber+=octalNumbers%10 * (int)Math.pow(8,i);
            i++;
            octalNumbers/=10;
        }
        return decNumber;


    }
}
