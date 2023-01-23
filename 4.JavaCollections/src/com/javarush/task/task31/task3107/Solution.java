package com.javarush.task.task31.task3107;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path pathToFileP = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(pathToFileP),Files.isExecutable(pathToFileP),Files.isDirectory(pathToFileP),Files.isWritable(pathToFileP));

        }
        catch (Exception e)
        {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
