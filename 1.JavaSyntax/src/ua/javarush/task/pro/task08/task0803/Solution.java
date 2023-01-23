package ua.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Мінімальний елемент масиву
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        //напишіть тут ваш код
        int min_value = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            min_value = Math.min(min_value,ints[i]);
        }
            return min_value;


    }

    public static int[] getArrayOfTenElements() {
        //напишіть тут ваш код
        Scanner k = new Scanner(System.in);
        int[] val_array= new int[10];
        for (int i = 0; i < 10; i++)
        {
            val_array[i] = k.nextInt();
        }
        return val_array;
    }
}
