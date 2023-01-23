package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor{
    public static int counterOfDirectory = 0;
    public static int counterOfFiles = 0;
    public static long allSize = 0;


    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            Path path = Paths.get(bufferedReader.readLine());
            if (!Files.isDirectory(path))
            {
                System.out.printf("%s - не папка",path.toString());
                return;
            }
            else
            {
                EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
                final Solution solution = new Solution();
                Files.walkFileTree(path,options,20,solution);
                System.out.printf("Всего папок - %s\n",counterOfDirectory-1);
                System.out.printf("Всего файлов - %s\n",counterOfFiles);
                System.out.printf("Общий размер - %s",allSize);

            }

        }
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory((Path) file))
            counterOfDirectory++;
        if (Files.isRegularFile((Path)file ))
        {
            //allSize+=Files.size((Path) file);
            allSize+=attrs.size();
            counterOfFiles++;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        counterOfDirectory++;
        return super.preVisitDirectory(dir, attrs);
    }
}
