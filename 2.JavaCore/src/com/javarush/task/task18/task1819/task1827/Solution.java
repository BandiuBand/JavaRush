package com.javarush.task.task18.task1819.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;
        if (args[0].equals("-c"))
        {
            String[] parametr =  new String[3];
            for (int i = 0; i < 3; i++) {
            parametr[i] = args[i+1];
            }
            addTovar(parametr);
        }

    }
    private static void addTovar(String[] arg) {
        int maxId = 0;
        String path = new Scanner(System.in).nextLine();
        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(path)))
        {
            String line;
            while ((line = bufferedReader.readLine())!=null)
            {
                int id = Integer.parseInt(line.substring(0,8).trim());
                if (id > maxId)
                    maxId = id;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] id = new char[8];
        Arrays.fill(id,' ');

        id = String.valueOf((maxId+1)).toCharArray();
        char[] productNName = new char[30];
        char[] price = new char[8];
        char[] quantity = new char[4];
        Arrays.fill(productNName,' ');
        Arrays.fill(price,' ');
        Arrays.fill(quantity,' ');
        for (int i = 0; i < arg[0].length(); i++) {
            productNName[i] = arg[0].charAt(i);
        }

        for (int i = 0; i < arg[1].length(); i++) {
            price[i] = arg[1].charAt(i);
        }

        for (int i = 0; i < arg[2].length(); i++) {
            quantity[i] = arg[2].charAt(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n').append(id).append(productNName).append(price).append(quantity);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true))){
            bufferedWriter.append(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
