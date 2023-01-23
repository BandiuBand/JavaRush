package com.javarush.task.task18.task1818;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    private static String path1;
    private static String path2;
    private static String path3;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
         path1 = scanner.nextLine();
         path2 = scanner.nextLine();
         path3 = scanner.nextLine();
         //myVariant();
        validatorVariant();

    }

    private static void validatorVariant() throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path1)))
        {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path2)))
            {
                    while (bufferedInputStream.available() > 0)
                        bufferedOutputStream.write(bufferedInputStream.read());
            }
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path3))){
                    while (bufferedInputStream.available() > 0)
                        bufferedOutputStream.write(bufferedInputStream.read());
            }
        }
    }






    private static void myVariant()
    {
        List<Byte> bytes = new ArrayList<>();
        try (BufferedInputStream bufferedI = new BufferedInputStream(new FileInputStream(path2))){
            while (bufferedI.available()>0)
                bytes.add((byte) bufferedI.read());
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (BufferedInputStream bufferedI = new BufferedInputStream(new FileInputStream(path3))){
            while (bufferedI.available()>0)
                bytes.add((byte) bufferedI.read());
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path1)))
        {
            for (Byte byt:bytes) {
                bufferedOutputStream.write(byt);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
