//package com.javarush.task.task22.task2211;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//
///*
//Смена кодировки
//*/
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        String from = args[0];//"c:\\2\\2.txt";
//        String where = args[1];//"c:\\2\\1.txt";
//        Charset charsetWin= Charset.forName("Windows-1251");
//        try (BufferedReader reader = new BufferedReader(new FileReader(from,charsetWin));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(where,StandardCharsets.UTF_8))){
//            String buf;
//            while ((buf = reader.readLine())!=null)
//            {
//                writer.write(buf+"\n");
//            }
//            writer.flush();
//        }
//    }
//}
package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {

            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
            }
        }
    }
}
