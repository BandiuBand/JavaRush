package ua.javarush.task.pro.task13.task1306;

import java.util.ArrayList;
import java.util.Collections;

/* 
Вивчаємо методи класу Collections, частина 1
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static void copy(ArrayList<String> destination, ArrayList<String> source) {
        if(destination.size() < source.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        Collections.copy(destination,source);

    }

    public static void addAll(ArrayList<String> list, String... strings) {
        Collections.addAll(list,strings);
        /*for (String string : strings) {
            list.add(string);
        }*/
    }

    public static void replaceAll(ArrayList<String> list, String oldValue, String newValue) {
        Collections.replaceAll(list,oldValue,newValue);
        /*for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);
            if(string.equals(oldValue)) {
                list.set(i, newValue);
            }
        }

         */
    }
}
