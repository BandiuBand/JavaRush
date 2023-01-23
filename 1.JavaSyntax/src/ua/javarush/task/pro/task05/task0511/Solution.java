package ua.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Створюємо двовимірний масив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишіть тут ваш код
        Scanner k = new Scanner(System.in);
        int N = k.nextInt();
        int[] size = new int[N];
        /*int[][]*/ multiArray = new int[N][];
        for (int i = 0; i < N; i++) {
           // size[i] = k.nextInt();
            multiArray[i] =new int[k.nextInt()];
        }
        for (int i = 0; i < N; i++) {
               //multiArray[i] =new int[j];
            for (int j = 0; j <multiArray[i].length ; j++) {
                System.out.print(multiArray[i][j]+"[]");
            }
            System.out.println();
        }
    }
}
