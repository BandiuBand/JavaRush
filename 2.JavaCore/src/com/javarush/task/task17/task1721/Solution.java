package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        String pathFr = (new Scanner(System.in)).nextLine().toString();
        String pathRe = (new Scanner(System.in)).nextLine().toString();
        Reader froam = new Reader(pathFr);
        Reader removLines = new Reader(pathRe);
        froam.join();
        removLines.join();
        allLines = froam.getList();
        forRemoveLines = removLines.getList();
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Щось пішло не так...");;
        }
        System.out.println(allLines);

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        } else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
private static class Reader extends Thread
{
    private String path;
    private List<String> list = new ArrayList<>();
    public Reader(String path)
    {
        this.path = path;
        this.start();
    }

    public List<String> getList() {
        return list;
    }

    public void run()
    {

        if (this.isInterrupted())
            return;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String s;
            while ((s = bufferedReader.readLine())!=null)
            {
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
}
