package ua.javarush.task.pro.task12.task1211;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Сортування бульбашкою
*/

public class Solution {


    public static int[] numbers = {56, 45, 89, 1, 45, 13, 4, 69, 11, -89};

    //public static ArrayList<Integer> numberss = new ArrayList<>(Arrays.asList(56, 45, 89, 1, 45, 13, 4, 69, 11, -89));

    public static void main(String[] args) {
        print();
        sort();
        System.out.println("\nВідсортовані числа в порядку зростання:");
        print();
    }

    public static void sort() {
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = 0; j < numbers.length - 1; j++)
            {
                if (numbers[j] > numbers[j+1])
                {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }




        /*for (int i = 0; i < numberss.size() - 1; i++) {
            for (int j = 0; j < numberss.size() - i - 1; j++) {
                if (numberss.get(j) > numberss.get(j + 1)) {
                    int temp = numberss.get(j);
                    numberss.set(j, numberss.get(j + 1));
                    numberss.set(j + 1, temp);
                }
            }
        }

         */
    }

    public static void print() {
        for (int number : numbers) {
            System.out.print(number + "\t");
        }
        /*System.out.println();
        for (int number : numberss) {
            System.out.print(number + "\t");
        }

         */
    }
}
