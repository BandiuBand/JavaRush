package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        int count = 0;
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        String result =byteArrayOutputStream.toString();
        System.setOut(consoleStream);
        String[] lines = result.split("\\n");

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            if (i%2 != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

    }


    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

