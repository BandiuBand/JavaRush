package ua.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двійково-шістнадцятковий конвертер
*/

public class Solution {
    private static boolean errFlag = false;
    public static void main(String[] args) {
        String binaryNumber = null;
        System.out.println("Двійкове число " + binaryNumber + " дорівнює шістнадцятковому числу " + toHex(binaryNumber));
        String hexNumber = null;
        System.out.println("Шістнадцяткове число " + hexNumber + " дорівнює двійковому числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишіть тут ваш код
        //напишіть тут ваш код
        errFlag = false;
        String sub = new String();
        int i = 0;
        StringBuilder res = new StringBuilder();
        if ((binaryNumber == null) || (binaryNumber == ""))
            return "";
        if (binaryNumber.length()%4 != 0)
            for (int j = 0; j < binaryNumber.length()%4; j++) {
                binaryNumber = "0" + binaryNumber;
            }
        while (binaryNumber.length() > 3)
        {
            sub = binaryNumber.substring(0, 4);
            binaryNumber = binaryNumber.substring(4);
            res.append(conver(sub));
        }
        if (errFlag == false)
        return res.toString();
        else
        return "";
    }

    static char conver(String subNumber)
    {
        for (int j = 0; j < 4; j++)
        {
            if ((subNumber.charAt(j) != '1') && (subNumber.charAt(j) != '0'))
                errFlag = true;
        }
            if (subNumber.equals("0000"))
                return '0';
            else if (subNumber.equals("0001"))
                return '1';
            else if (subNumber.equals("0010"))
                return '2';
            else if (subNumber.equals("0011"))
                return '3';
            else if (subNumber.equals("0100"))
                return '4';
            else if (subNumber.equals("0101"))
                return '5';
            else if (subNumber.equals("0110"))
                return '6';
            else if (subNumber.equals("0111"))
                return '7';
            else if (subNumber.equals("1000"))
                return '8';
            else if (subNumber.equals("1001"))
                return '9';
            else if (subNumber.equals("1010"))
                return 'a';
            else if (subNumber.equals("1011"))
                return 'b';
            else if (subNumber.equals("1100"))
                return 'c';
            else if (subNumber.equals("1101"))
                return 'd';
            else if (subNumber.equals("1110"))
                return 'e';
            else if (subNumber.equals("1111"))
                return 'f';


        return '0';
    }

    public static String toBinary(String hexNumber) {
        //напишіть тут ваш код
        if ((hexNumber == null) || hexNumber.equals(""))
            return "";
        int leng = hexNumber.length();
        for (int i = 0; i <leng ; i++)
        {
           if (check(hexNumber.charAt(i)))
               return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            res.append(convToBin(hexNumber.charAt(i)));
        }
        return res.toString();
    }

    static String convToBin(char symbol)
    {
        switch (symbol)
        {
            case ('0'):
                return "0000";
            case ('1'):
                return "0001";
            case ('2'):
                return "0010";
            case ('3'):
                return "0011";
            case ('4'):
                return "0100";
            case ('5'):
                return "0101";
            case ('6'):
                return "0110";
            case ('7'):
                return "0111";
            case ('8'):
                return "1000";
            case ('9'):
                return "1001";
            case ('a'):
                return "1010";
            case ('b'):
                return "1011";
            case ('c'):
                return "1100";
            case ('d'):
                return "1101";
            case ('e'):
                return "1110";
            case ('f'):
                return "1111";
        }
        return null;
    }
    static boolean check(char a) {
    return (a != '0') && (a != '1') &&(a != '2') &&(a != '3') &&(a != '4') &&(a != '5') &&(a != '6') &&(a != '7') &&(a != '8') &&(a != '9') &&(a != 'a') &&(a != 'b') &&(a != 'c') &&(a != 'd') &&(a != 'e') &&(a != 'f');
    }
}
