package ua.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двійковий конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 1;
        System.out.println("Десяткове число " + decimalNumber + " дорівнює двійковому числу " + toBinary(decimalNumber));
        String binaryNumber ="1";
        System.out.println("Двійкове число " + binaryNumber + " дорівнює десятковому числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        //напишіть тут ваш код
        if (decimalNumber <= 0)
        return "";
        
        int count = 0;
        char[] charArrOfBinNumb = new char[64];
        while (decimalNumber != 0)
        {
             if (decimalNumber%2 == 1)
             
             charArrOfBinNumb[count] = '1';
             
             else 
             
             charArrOfBinNumb[count] = '0';
             
             decimalNumber= decimalNumber / 2;
             count++;
        }
        return charToSt(charArrOfBinNumb,count-1);
    }

    public static int toDecimal(String binaryNumber) {
        //напишіть тут ваш код
        if ((binaryNumber==null) || binaryNumber.equals("")  )
        return 0;
        
        int numberDec = 0;
        char[] charOfBin = new char[binaryNumber.length()];
        
        charOfBin = binaryNumber.toCharArray();
        
        for (int i = 0; i < (charOfBin.length);i++)
        {
            if (charOfBin[charOfBin.length - 1 - i] == '1')
               numberDec+= stepDvoik(i);
        }
        return numberDec;
    }
    
    public static int stepDvoik (int stepen)
        {
          int res =1;
           if (stepen == 0)
           return 1;
           
            for (int i = 0; i < stepen; i++ )
            {
                res *=2; 
            }
        
           // System.out.println(res + "of st = " + stepen);
            return res;
        }
    
    public static String charToSt(char[] Chr,int leng)
    {
        StringBuilder bild = new StringBuilder();
        
        for (int i = leng; i >= 0;i--)
           {
            bild.append(Chr[i]);   
           }
        return bild.toString();   
    }
    
    /*public static boolean checkD(int number)
    {
        return (number <= 0);
    }
    */
    /*public static boolean checkB(String number)
    {
        return ((number.equals(null)) || (number.equals("")));
    }

     */
}
