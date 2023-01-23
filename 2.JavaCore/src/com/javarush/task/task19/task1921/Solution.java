package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String path1 = args[0];
        List<String> allLines = read(path1);
        allLines.forEach(x->PEOPLE.add(parseLine(x)));
        //System.out.println();

    }
    private static Person parseLine(String line)
    {
        String[] parsedLines = line.split(" ");
        String name = parseName(parsedLines);
        int day = Integer.parseInt(parsedLines[parsedLines.length-3]);
        int mounth = Integer.parseInt(parsedLines[parsedLines.length-2]);
        int year = Integer.parseInt(parsedLines[parsedLines.length-1]);
        Person person= new Person(name,makeData(day,mounth,year));
        //System.out.println(person.toString());
        return person;
    }
    private static Date makeData(int day,int mounth,int year)
    {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year,mounth-1,day);
        return gregorianCalendar.getTime();
    }

    private static String parseName(String[] lines)
    {   StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.length-3; i++) {
            stringBuilder.append(lines[i]).append(" ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
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
