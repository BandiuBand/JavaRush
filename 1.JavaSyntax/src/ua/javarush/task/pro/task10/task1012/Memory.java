package ua.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментація пам'яті
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        //напишіть тут ваш код
        int leng =array.length;
        String[] temporary = new String[leng];
        int j = 0;
        for (int i = 0; i < leng; i++) {
            if (array[i]!= null) {
                temporary[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < leng; i++) {
            array[i] = temporary[i];
        }

    }
}
