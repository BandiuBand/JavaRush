package ua.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успішність студентів
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Вася",1.0);
        grades.put("Вася1",2.0);
        grades.put("Вася2",3.0);
        grades.put("Вася3",4.0);
        grades.put("Вася4",5.0);


        //напишіть тут ваш код
    }
}
