package com.javarush.task.task18.task1814;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private String path;
    FileInputStream fileInputStream ;
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
            if (fileName.endsWith(".txt")) {

            } else {
                super.close();
                throw new UnsupportedFileNameException();
            }

    }




    public static void main(String[] args) {
    }
}

