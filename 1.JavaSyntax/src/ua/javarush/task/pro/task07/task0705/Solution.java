package ua.javarush.task.pro.task07.task0705;

/* 
Нескінченність — не межа
*/

public class Solution {
    public static void main(String[] args) {
        //напишіть тут ваш код
        div(0,10.0);
        div(0,-10);
    }

    public static void div(double a, double b){
        System.out.println(b/a);
    }
}
