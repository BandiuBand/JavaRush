package ua.javarush.task.pro.task13.task1310;

import java.util.HashMap;

/* 
Успішність студентів-2
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println("Список студентів групи: ");
        printStudents();
        System.out.print("Середній бал групи: " + getAverageMark());
    }

    public static void addStudents() {
        grades.put("Давидов Олег", 4.3d);
        grades.put("Шульга Микола", 4.1d);
        grades.put("Колос Василь", 4.9d);
        grades.put("Шевченко Тарас", 3.7d);
        grades.put("Марчук Любослав", 3.2d);
    }

    public static void printStudents() {
        for (String key:grades.keySet()) {
            System.out.println(key);
        }
        //напишіть тут ваш код
    }

    public static Double getAverageMark() {
        //напишіть тут ваш код
        double sumMark = 0.0;
        int count = 0;
        for (String key : grades.keySet()) {
            sumMark += grades.get(key);
            count++;
        }
    return count > 0? sumMark/count : 0.0;
    }
}
