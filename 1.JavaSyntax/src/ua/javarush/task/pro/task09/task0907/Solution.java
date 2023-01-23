package ua.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шістнадцятковий конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1234;
        System.out.println("Десяткове число " + decimalNumber + " дорівнює шістнадцятковому числу " + toHex(decimalNumber));
        String hexNumber = null;
        System.out.println("Шістнадцяткове число " + hexNumber + " дорівнює десятковому числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        //напишіть тут ваш код
        if (decimalNumber <= 0)
        return "";
        StringBuilder HexN = new StringBuilder();
        while (decimalNumber > 0)
        {
            //System.out.println(decimalNumber%16 + "остаток від ділення");
            HexN.append(dToHe(decimalNumber%16));
            //System.out.println(dToHe(decimalNumber%16)+"остаток в16");
            decimalNumber /=16; 
            //System.out.println(decimalNumber + " після віднімання");
        }
        HexN.reverse();
        return HexN.toString();
    }
    
    static char dToHe(int rozr)
    {
        if ((rozr >=0)&&(rozr <= 9))
        return Character.forDigit(rozr,10);
        switch (rozr)
        {
            case (10):
                return 'a';
            case (11):
                return 'b';
            case (12):
                return 'c';
            case (13):
                return 'd';
            case (14):
                return 'e';
            case (15):
                return 'f';
        }
            return ' ';
    }

        static char[] convertStToChar(String srt,int leng)
        {
            char[] ch = new char[leng];
            ch = srt.toCharArray();
            return ch;
        }
    public static int toDecimal(String hexNumber) {
        //напишіть тут ваш код
        if ((hexNumber == null) || (hexNumber.equals("")))
            return 0;
        int leng = hexNumber.length();
        char[] hexNumberCh = new char[leng];
        hexNumberCh=convertStToChar(hexNumber,leng);
        int res = 0;
        for (int i = 0; i  < leng; i++)
        {
            res+=hCharConvert(hexNumberCh[leng-1-i]) * stepen(i);
        }
        return res;
    }
    static int stepen(int e)
    {
        if (e == 0)
        return 1;
        int res = 1;
        for (int i = 1; i <= e; i++)
        {
            res *= 16;
        }
        return res;
    }
    static int hCharConvert (char charOfHsymbol)
    {
        System.out.println(charOfHsymbol);
        switch (charOfHsymbol)
        {
            case ('1'):
                return (1);
            case ('2'):
                return (2);
            case ('3'):
                return (3);
            case ('4'):
                return (4);
            case ('5'):
                return (5);
            case ('6'):
                return (6);
            case ('7'):
                return (7);
            case ('8'):
                return (8);
            case ('9'):
                return (9);
            case ('0'):
                return (0);
            case ('a'):
                return (10);
            case ('b'):
                return (11);
            case ('c'):
                return (12);
            case ('d'):
                return (13);
            case ('e'):
                return (14);
            case ('f'):
                return (15);
        }
        System.out.println("біда");
        return 0;
    }
}
