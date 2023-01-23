package com.javarush.task.task19.task1915;

import java.io.*;
import java.util.Scanner;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String path = scanner.readLine();
        scanner.close();
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(consoleStream);
        try (FileOutputStream fileOutputStream = new FileOutputStream(path))
        {
            fileOutputStream.write(result.getBytes());
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

