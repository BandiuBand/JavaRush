package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String,String> p = new TreeMap<>();
        p.put("name",null);
        p.put("country",null);
        p.put("city",null);
        p.put("age",null);
        System.out.println(getQuery(p));
    }

    public static String getQuery(Map<String, String> params) {
        String result = getAllParamFormated(params);
        return result;
    }
    private static String getOneLineString (Map.Entry<String,String> entry)
    {   String res = String.format("%s = \'%s\'",entry.getKey(),entry.getValue());
        return res;
    }
    private static String getAllParamFormated(Map<String,String> param)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        for (Map.Entry entry: param.entrySet()) {
            if (entry.getValue()==null||entry.getKey()==null)
            {}
            else
            {
                stringBuilder.append(getOneLineString(entry)).append(" and ");
            }

        }
        if (stringBuilder.length()>5)

        stringBuilder.delete(stringBuilder.length()-5,stringBuilder.length());
        return stringBuilder.toString();
    }
}
