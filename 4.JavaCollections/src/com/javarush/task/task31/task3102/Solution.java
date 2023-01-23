package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> getFileTree = new ArrayList<>();
        Queue<File> queue = new ArrayDeque<>();
        File roo = new File(root);
        queue.add(roo);
        while (!queue.isEmpty())
        {
            if (queue.element().isDirectory())
            {
                //getFileTree.add(queue.element().getPath());
                for (File f: queue.poll().listFiles()) {
                    queue.add(f);
                }
            }
            else getFileTree.add(queue.poll().getAbsolutePath());
        }

        return getFileTree;

    }

    public static void main(String[] args) throws IOException {
        for (String s: getFileTree("c:\\2")) {
            System.out.println(s);
        }
    }
}
