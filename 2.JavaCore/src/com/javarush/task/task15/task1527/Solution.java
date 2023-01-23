package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        if (url.contains("?") && url.contains("&"))
        {
            int indexQvastion = url.indexOf('?') + 1;
            String subStr = url.substring(indexQvastion,url.length());
            list = gerParametr(subStr,list);
            //напишите тут ваш код
        }
        System.out.println();
        list.forEach((x)->
        {
            if (isDouble(x))

                alert(Double.parseDouble(x.substring(x.indexOf("=")+1,x.length())));
            else
                alert(x.substring(x.indexOf("=")+1,x.length()));
                //alert(x.substring(x.indexOf("=")+1,x.length()));
        });
        //System.out.println(list);
    }
    private static boolean isDouble(String x)
    {
        boolean f = false;
        try
        {
            Double.parseDouble(x.substring(x.indexOf("=")+1,x.length()));
            f = true;
        }
        catch (NumberFormatException e)
        {

        }
        finally
        {
            return f;
        }

    }
    public static List<String> gerParametr(String subStr, List<String> list)
    {

        String res;

            int indexConc = subStr.indexOf('&');
            if (indexConc < 0) {
                indexConc = subStr.length();
                res = subStr.substring(0,indexConc);
                String retRes = res(res);
                if (!retRes.equals(""))
                    list.add(retRes);
            } else
            {
                res = subStr.substring(0,indexConc);
            String retRes = res(res);
            if (!retRes.equals(""))
                list.add(retRes);
            subStr = subStr.substring(indexConc + 1,subStr.length());
            list = gerParametr(subStr,list);
            }
            return list;
    }
    public static String res(String str)
    {
        if (str.contains("="))
        {
            if (str.contains("obj"))
            {
                System.out.print("obj ");
                return str;
            }
            else
            {
                String subS = str.substring(0,str.indexOf("="));
                System.out.print(subS + " ");
                return "";
            }

        }
        System.out.print(str + " ");
        return "";
    }
//    private String isObj(String strObj)
//    {
//        String subSrt = strObj.substring(strObj.indexOf("=")+1,strObj.length());
//        if (subSrt.contains("."))
//            alert(Double.parseDouble(subSrt));
//
//    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
