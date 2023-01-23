package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();



    public static void main(String[] args) throws IOException {

        String[] paths = getPath();

        List<String> file1 = read(paths[0]);
        List<String> file2 = read(paths[1]);
        solCompLines(file1,file2);
        lines.forEach(x-> System.out.println(x.toString()));
    }
    private static String[] getPath() throws IOException {
        String[] pachs = new String[2];
        try (BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in))){
            pachs[0] = (new String(bufferedReader.readLine()));
            pachs[1] = (new String(bufferedReader.readLine()));
        }
        return pachs;

    }
    private static void solCompLines (List<String> file1,List<String> file2)
    {
        int i = 0;
        int j = 0;
        while (i < file1.size() && j < file2.size())
        {
            if (comarLin(file1.get(i),file2.get(j)))
            {
                lines.add(new LineItem(Type.SAME,file1.get(i)));
                i++;
                j++;
            } else if(comarLin(file1.get(i+1),file2.get(j))){
                lines.add(new LineItem(Type.REMOVED,file1.get(i)));
                i++;
            } else {
                lines.add(new LineItem(Type.ADDED,file2.get(j)));
                j++;
            }
        }
        if (i < file1.size() || j < file2.size())
        {
            if (i == file1.size()-1)
                lines.add(new LineItem(Type.REMOVED,file1.get(i)));
            else lines.add(new LineItem(Type.ADDED,file2.get(j)));
        }
    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString()
        {
            return type + "   " + line;
        }
    }
    private static boolean comarLin (String l1, String l2)
    {   if (l1==null || l2==null)
        return false;
        return l1.equals(l2);
    }
    private static List<String> read(String path) throws IOException {
        List<String> allLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                allLines.add(bufferedReader.readLine());
            }
        }
        return allLines;
    }
}
