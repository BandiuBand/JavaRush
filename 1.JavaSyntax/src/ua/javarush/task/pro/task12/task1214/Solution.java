package ua.javarush.task.pro.task12.task1214;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Бувай, Паскалю
*/

public class Solution {
    public static ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList("C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));

    public static void main(String[] args) {
        //напишіть тут ваш код
        print();
        programmingLanguages.remove("Pascal");
        System.out.println();
        print();

    }
    public static void print()
    {
        for (String A:programmingLanguages) {
            System.out.println(A);
        }
    }
}
