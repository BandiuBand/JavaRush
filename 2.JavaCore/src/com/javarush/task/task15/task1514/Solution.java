package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {

    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(0.00, "");
        labels.put(3.29d, "oisADFuy");
        labels.put(3.21d, "dasfasdfagfs");
        labels.put(3.23d, "oiasfsADFuy");
        labels.put(3.2353d, "oia,mgnsfsADFuy");
    }

        public static void main(String[] args) {
        System.out.println(labels);
    }

}
