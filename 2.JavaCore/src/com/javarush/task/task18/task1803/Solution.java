package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxMeatByte = 0;
        int countMeat = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> bytes = new ArrayList<>();
   //     System.out.println("Введіть шлях до файлу");
        try (FileInputStream fileInputStream =
                     new FileInputStream(
                             new Scanner(
                                     System.in)
                                     .nextLine()))
        {
                while (fileInputStream.available() > 0) {
                    int byt = fileInputStream.read();
                    if (map.containsKey(byt)) {
                        int newValCounter = map.get(byt) + 1;
                        map.put(byt,newValCounter);
                    } else
                        map.put(byt,0);
                    }

            for (Map.Entry entry : map.entrySet())
            {
                int key = (int) entry.getKey();
                int curentCounMeet = (int)entry.getValue();
                if (curentCounMeet > countMeat)
                {
                    countMeat = curentCounMeet;
                   maxMeatByte = key;}

            }
            for (Map.Entry entry : map.entrySet()) {
                if ((int)entry.getValue() == countMeat)
                    bytes.add((int)entry.getKey());
            }


        } catch (Exception e)
        {
            System.out.println("Щось пішло не так");
        }
        StringBuilder stringBuilder = new StringBuilder();
        bytes.forEach( x -> stringBuilder.append(x).append(" "));
        String result = stringBuilder.toString();
        System.out.print(result.substring(0 ,result.length()-1));
    }
}
