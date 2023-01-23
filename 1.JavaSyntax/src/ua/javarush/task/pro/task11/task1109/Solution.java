package ua.javarush.task.pro.task11.task1109;

/* 
Об'єкти внутрішніх і вкладених класів
*/

import javax.print.attribute.standard.MediaSize;

public class Solution {
    public static void main(String[] args) {
        //напишіть тут ваш код
        Outer c = new Outer();
        Outer.Inner a = c.new Inner();
        Outer.Nested b = new Outer.Nested();

    }
}
