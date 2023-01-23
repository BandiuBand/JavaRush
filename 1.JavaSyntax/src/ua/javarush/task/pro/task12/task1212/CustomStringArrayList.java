package ua.javarush.task.pro.task12.task1212;

/* 
Створюємо свій список
*/

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишіть тут ваш код
        String[] copy = new String[capacity];
        copy = elements;
        capacity +=capacity/2 ;
        elements = new String[capacity];
        for (int i = 0; i < copy.length; i++)
        {
            elements[i] = copy[i];
        }
    }

    public static void main(String[] args) {
        CustomStringArrayList A = new CustomStringArrayList();
        for (int i = 0; i < 100; i++) {


        A.add(String.valueOf(i));
        }
    }
}
