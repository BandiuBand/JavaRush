package com.javarush.task.task18.task1828;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы 2
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        switch (args[0]) {
            case "-u": {
                int id = Integer.parseInt(args[1]);
                String name = "";
                for (int i = 2; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                Product productToUpdate = null;
                for (Product product : products) {
                    if (product.id == id) productToUpdate = product;
                }
                if (productToUpdate != null) {
                    productToUpdate.name = name;
                    productToUpdate.price = price;
                    productToUpdate.quantity = quantity;
                }
                break;
            }
            case "-d": {
                int id = Integer.parseInt(args[1]);
                Product productToDelete = null;
                for (Product product : products) {
                    if (product.id == id) productToDelete = product;
                }
                if (productToDelete != null) products.remove(productToDelete);
                break;
            }
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}










//package com.javarush.task.task18.task1828;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
///*
//Прайсы 2
//*/
//
//public class Solution {
//    private static String path;
//    private static String[] getParametr(String[] args)
//    {
//        String[] parametr =  new String[args.length-1];
//        for (int i = 0; i < (args.length-1); i++) {
//            parametr[i] = args[i+1];
//        }
//        return parametr;
//    }
//    public static void main(String[] args) throws Exception {
//        if (args.length == 0)
//            return;
//        if (args[0].equals("-u")) refresh(getParametr(args));
//        else if (args[0].equals("-d")) delite(getParametr(args));
//
//
//    }
//
//    private static void delite(String[] parametr) {
//        int fid = Integer.parseInt(parametr[0]);
//        List<String> file = reader();
//        int index= searchEl(fid,file);
//        if (index >= 0 )
//        file.remove(index);
//        writer(file);
//    }
//
//        private static void refresh(String[] parametr) {
//        int fid = Integer.parseInt(parametr[0]);
//        List<String> file = reader();
//        int index= searchEl(fid,file);
//        if (index >= 0 )
//            file.set(index,(getTovarString(fid,parametr)));
//        writer(file);
//    }
//    private static void writer(List<String> file) {
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
//            for (String line:file) {
//                bufferedWriter.write(line);
//                bufferedWriter.write("\n");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//   private static List<String> reader() {
//        path = new Scanner(System.in).nextLine();
//        List<String> allLines = new ArrayList<>();
//        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(path)))
//        {
//            String line;
//            while ((line = bufferedReader.readLine())!=null)
//            {
//                allLines.add(line);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return allLines;
//    }
//
//    private static int searchEl(int fid, List<String> file) {
//        int index = -1;
//        for (String l:file) {
//            if (Integer.parseInt(l.substring(0, 8).trim()) == fid)
//            {
//                index = file.lastIndexOf(l);
//            }
//
//        }
//        return index;
//    }
//    private static String getTovarString(int id,String[] arg) {
//        char[] idArray = new char[8];
//        char[] productNName = new char[30];
//        char[] price = new char[8];
//        char[] quantity = new char[4];
//        Arrays.fill(productNName,' ');
//        Arrays.fill(price,' ');
//        Arrays.fill(quantity,' ');
//        for (int i = 0; i < ((Integer)id).toString().length(); i++) {
//            idArray[i] = ((Integer)id).toString().charAt(i);
//        }
//        for (int i = 0; i < arg[1].length(); i++) {
//            productNName[i] = arg[1].charAt(i);
//        }
//
//        for (int i = 0; i < arg[2].length(); i++) {
//            price[i] = arg[2].charAt(i);
//        }
//
//        for (int i = 0; i < arg[3].length(); i++) {
//            quantity[i] = arg[3].charAt(i);
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(idArray).append(productNName).append(price).append(quantity);
//        return stringBuilder.toString();
//
//    }
//}
//
