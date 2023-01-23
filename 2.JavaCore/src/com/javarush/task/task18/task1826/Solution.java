package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
    if (args == null ||   (!   (    args[0].equals("-e")   ||   (args[0].equals("-d"))    )))
        return;
        String fileName = args[1];
        String fileOutputName = args[2];
        if (args[0].equals("-e")) {
            cript(fileName,fileOutputName);
        }else {
            UnCript(fileName,fileOutputName);
        }
    }

    private static void UnCript(String fileName, String fileOutputName) {
        try (BufferedInputStream bufferedInputStream =new BufferedInputStream( new FileInputStream(fileName))){
            try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutputName))){
                while (bufferedInputStream.available()>0)
                    bufferedOutputStream.write(((byte)bufferedInputStream.read()-66));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void cript(String fileName, String fileOutputName) {
        try (BufferedInputStream bufferedInputStream =new BufferedInputStream( new FileInputStream(fileName))){
            try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutputName))){
                while (bufferedInputStream.available()>0)
                bufferedOutputStream.write(((byte)bufferedInputStream.read()+66));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }