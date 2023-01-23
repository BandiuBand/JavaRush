package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        String path1 = args[0];
        List<String> allLines = read(path1);
        SortedMap<String,Double> result =  new TreeMap<>();



        List<String> name = new ArrayList<>();
        List<Double> numbers = new ArrayList<>();

        List<Object> list = getMap(allLines);

        name = (List<String>) list.get(0);
        numbers = (List<Double>) list.get(1);


        for (int i= 0; i < name.size();i++) {
            result.put(name.get(i),0.0);
        }
        for (int i= 0; i < name.size();i++) {
            if(result.containsKey(name.get(i)))
            {

                String k = name.get(i);
                Double v = result.get(k);
                Double value = adder(v,numbers.get(i));
                result.put(k,value);
            }
        }
        for (Map.Entry e:result.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    private static Double adder (Double n1,Double n2)
    { double nN1 = 0;
        double nN2 =0;
        if (n1 != null)
            nN1 = n1;
        if (n2 != null)
            nN2 =  n2;
        return (Double)(nN1+nN2);
    }

    private static List<Object> getMap(List<String> allLines)
    {
        List<String> name = new ArrayList<>();
        List<Double> numbers = new ArrayList<>();
        for (String line:allLines) {
            String[] arLine=line.split(" ");
            name.add(arLine[0]);
            numbers.add(Double.parseDouble(arLine[1]));

        }
        List<Object> list  = new ArrayList<>();
        list.add(name);
        list.add(numbers);
        return list;
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
