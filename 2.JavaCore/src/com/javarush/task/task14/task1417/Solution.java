package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        private List<Money> allMoney ;
        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>()
                     {{
                add(new Hryvnia(0));
                add(new Ruble(0));
                add(new USD(0));

            }};
            //напишите тут ваш код
        }




        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
