package com.javarush.task.task33.task3308;

import java.util.List;

public class Shop {
    public Goods goods = new Goods();
 public int count;
 public double profit;
 public String[] secretData;

    public Shop() {
    }

    public static class Goods
 {
     List<String> names;

     public Goods() {
     }
 }
}
