package ua.javarush.task.pro.task12.task1210;

import java.util.ArrayList;

/* 
Перевертання даних
*/

public class Solution {
    public static ArrayList<Integer> numbers = new ArrayList<>();
    //public static int[] numberss = new int[10];

    public static void main(String[] args) {
        init();
        print();

        reverse();
        print();
    }

    public static void init() {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
           /* numberss[i] = i;

            */
        }
    }

    public static void reverse() {
        int nA = numbers.size();
        ArrayList<Integer> copy = new ArrayList<>(numbers);
        for (int i = 0; i < nA; i++) {
            numbers.set(i,copy.get(nA-1-i));
        }



        /*int n = numberss.length - 1;
        for (int i = 0; i < numberss.length / 2; i++) {
            int temp = numberss[i];
            numberss[i] = numberss[n - i];
            numberss[n - i] = temp;




        }

         */
    }

    private static void print() {
        for (Integer numb : numbers)
        {
            System.out.println(numb);
        }


        /*for (int number : numberss) {
            System.out.println(number);
        }

         */
    }
}
