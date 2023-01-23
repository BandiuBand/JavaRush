package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.*;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
        for (int i = 0; i < 100; i++) {
            ByteArrayOutputStream byteArrayOutputStream = getPassword();
            System.out.println(byteArrayOutputStream.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        Password password = new Password();
        return password.getPasswordRandom();
    }

    private static class Password
    {
        private String password;
        private int count_numbers;
        private int count_chars;
        private int count_UpperCaseChars;
        List<Symbol> symbolList = new ArrayList<>();
        public Password() {
            count_chars = ((int) Math.random() * 5) + 1;
            count_UpperCaseChars = ((int) (Math.random() * (6 - count_chars))) + 1;
            count_numbers = 8 - count_chars - count_UpperCaseChars;
            for (int i = 0; i < count_chars; i++) {
                symbolList.add(new Symbol(1));
            }
            for (int i = 0; i < count_UpperCaseChars; i++) {
                symbolList.add(new Symbol(2));
            }
            for (int i = 0; i < count_numbers; i++) {
                symbolList.add(new Symbol(0));
            }
            password = makePasvord();
        }
        public ByteArrayOutputStream getPasswordRandom()
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < password.length(); i++) {
                byteArrayOutputStream.write((int)password.charAt(i));
            }

            return byteArrayOutputStream;
        }

    private String makePasvord()
    {   String pas = "";
        StringBuilder stringBuilder = new StringBuilder();
        int rundomN = 0;
        while (symbolList.size()>0)
        {   if (symbolList.size()==1)
            rundomN = 0;
            else rundomN = getRundom(symbolList.size()-1);
            stringBuilder.append(symbolList.get(rundomN).getSymbol());
            symbolList.remove(rundomN);
        }
        pas = stringBuilder.toString();
        return pas;
    }
    private int getRundom(int lents)
    {
        return (int) ( Math.random() * (lents + 1) );
    }
    private static class Symbol
    {
        private int code = 0;//0->numbers;1->char;2->charUpperCase
        private char symbol;

        public Symbol (int code)
        {
            symbol = get_symbol(code);
        }

        public char getSymbol() {
            return symbol;
        }

        private static char get_symbol (int code)
        {   int shift = 65-97;
            switch (code)
            {
                case 0 : return randomNumber();
                case 1 : return rundomChar();
                case 2 : return (char)((int)rundomChar() + shift);
            }
            return '0';

        }
        private static char rundomChar()
        {
            return (char)((int)(Math.random() * 25)+97);
        }
        private static char randomNumber()
        {
            return  (char)((int)(Math.random() * 10)+48);
        }
    }

    }
}


