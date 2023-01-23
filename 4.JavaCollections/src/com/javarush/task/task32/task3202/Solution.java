package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:\\2\\1.txt"));
        //System.out.println("trallalla");
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);


        StringWriter stringWriter = new StringWriter();
        if (is != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (bufferedInputStream.available() > 0) {
                byte[] buffer = new byte[32];
                int zise = bufferedInputStream.read(buffer);
                byteArrayOutputStream.write(buffer, 0, zise);
            }
            String temp = byteArrayOutputStream.toString();

            if (temp == null)
                temp = "";
            stringWriter.append(temp);
        }
        return stringWriter==null?new StringWriter():stringWriter;
    }
}
