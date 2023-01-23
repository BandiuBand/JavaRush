package ua.javarush.task.pro.task07.task0706;

/* 
Дивне ділення
*/

public class Solution {
    public static void main(String[] args) {
        //напишіть тут ваш код
        double a = 10.0 / 0.0;
        double b = 10.0 / 0.0;
        div(a,b);
    }

    public static void div(double a, double b){
        System.out.println(b/a);
    }
}
