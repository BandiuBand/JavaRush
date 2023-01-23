package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        for (Map.Entry<String,String> entry: runtimeStorage.entrySet()) {
            properties.put((String)entry.getKey(),(String)entry.getValue());
        }
        properties.save(outputStream,null);
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry<Object,Object> entry:properties.entrySet()) {
            runtimeStorage.put((String)entry.getKey(),(String)entry.getValue() );
        }
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
//        runtimeStorage.put("sikouruak","Jane");
//        runtimeStorage.put("kolisnichenko","Anna");
//        runtimeStorage.put("chichi","null");
//        runtimeStorage.put("diana","dianosaurik");
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             FileOutputStream fos = new FileOutputStream(reader.readLine())){
//            save(fos);
//        }
    }
}
