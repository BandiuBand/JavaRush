package com.javarush.task.task17.task1711.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        if (args[0].equals("-c"))
        {
            doIfC(args);
        }
            else if (args[0].equals("-r"))
        {
            doIfR(args);
        }
            else if (args[0].equals("-u"))
        {
            doIfU(args);
        }
            else if (args[0].equals("-d"))
        {
            doIfD(args);
        }


    }
    private static void doIfC(String[] args) {
        String name = args[1];
        String sex = args[2];
        String bd = args[3];
        int index;
        // Person(String name, Sex sex, Date birthDate) {
        if (sex.equals("ж"))
        {
            try {
                synchronized (allPeople)
                {
                    index = allPeople.size();
                    allPeople.add(Person.createFemale(name,new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(bd)));




                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            try {
                synchronized (allPeople)
                {
                    index = allPeople.size();
                    allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd)));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(index);

    }

    private static void doIfR(String[] args)
    {
        int id = Integer.parseInt(args[1]);
        synchronized (allPeople)
        {
            allPeople.get(id).printPerson();
        }
    }

    private static void doIfU(String[] args)
    {   int id = Integer.parseInt(args[1]);
        String name = args[2];
        String sex = args[3];
        String bd = args[4];
        // Person(String name, Sex sex, Date birthDate) {
        if (sex.equals("ж"))
        {
            try {
                synchronized (allPeople)
                {
                    allPeople.set(id,Person.createFemale(name,new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(bd)));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            try {
                synchronized (allPeople)
                {
                    allPeople.set(id,Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd)));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        allPeople.get(id).printPerson();

    }

    private static void doIfD(String[] args)
    {
        allPeople.get(Integer.parseInt(args[1])).removePerson();

    }
}
