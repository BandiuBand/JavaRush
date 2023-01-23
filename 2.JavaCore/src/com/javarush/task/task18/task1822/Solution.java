package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        List<String> allLines = reader();
        if (args == null)
            return;
       searchEl(Integer.parseInt(args[0]),allLines);
        //System.out.println(allLines.get(searchEl(Integer.parseInt(args[0]),allLines)));

    }
    private static List<String> reader() {
        String path = new Scanner(System.in).nextLine();
        List<String> allLines = new ArrayList<>();
        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(path)))
        {
            String line;
            while ((line = bufferedReader.readLine())!=null)
            {
                allLines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allLines;
    }

    private static int searchEl(int fid, List<String> file) {
        int index = -1;
        for (String l:file) {
            if (l.startsWith(fid + " "))
            {
                System.out.println(l);
                //index = file.lastIndexOf(l);

            }

        }
        return index;
    }
    }

