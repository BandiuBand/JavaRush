package com.javarush.task.task19.task1914;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(defaultPrintStream);

        String result = byteArrayOutputStream.toString();
        String[] resultArray = result.split(" ");
        int firstNum = Integer.parseInt(resultArray[0]);
        int secondNum = Integer.parseInt(resultArray[2]);
        int arithmeticResult;

        if (resultArray[1].trim().equals("+"))
            arithmeticResult = firstNum + secondNum;
        else if (resultArray[1].trim().equals("-"))
            arithmeticResult = firstNum - secondNum;
        else
            arithmeticResult = firstNum * secondNum;

        System.out.println(firstNum + " " + resultArray[1] + " " + secondNum + " = " + arithmeticResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


//package com.javarush.task.task19.task1914;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.PrintStream;
//
///*
//Решаем пример
//*/
//
//public class Solution {
//    public static TestString testString = new TestString();
//
//    public static void main(String[] args) throws IOException {
//        PrintStream consoleStream = System.out;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PrintStream printStream = new PrintStream(byteArrayOutputStream);
//        System.setOut(printStream);
//        testString.printSomething();
//        String result = byteArrayOutputStream.toString();
//        System.setOut(consoleStream);
//
//        System.out.println(sol(result));
//    }
//
//    public static class TestString {
//        public void printSomething() {
//            System.out.println("3 + 6 = ");
//        }
//    }
//    private static String sol(String input)
//    {
//        String fistPartResult = input.substring(0,(input.length()-2));
//        String[] urrov = input.split(" ");
//        int a = Integer.parseInt(urrov[0]);
//        int b = Integer.parseInt(urrov[2]);
//        if (urrov[1].equals("+"))
//            return fistPartResult + String.valueOf(a+b);
//        else
//            return fistPartResult + String.valueOf(a-b);
//    }
//}
//
