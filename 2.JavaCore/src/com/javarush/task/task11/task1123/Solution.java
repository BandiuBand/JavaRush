package com.javarush.task.task11.task1123;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair result = getMinimumMaximumPair(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair getMinimumMaximumPair(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair(null, null);
        }
        ArrayList<Integer> arrayList= new ArrayList<>();
        for (int a:inputArray)
        {
            arrayList.add(a);
        }
        Optional<Integer> max = arrayList.stream().max((o1, o2) -> (Integer) o1 - (Integer) o2);
        Optional<Integer> min = arrayList.stream().min((o1, o2) -> (Integer) o1 - (Integer) o2);


        return new Pair(min.get(), max.get());
    }

    public static class Pair {
        public Integer x;
        public Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
