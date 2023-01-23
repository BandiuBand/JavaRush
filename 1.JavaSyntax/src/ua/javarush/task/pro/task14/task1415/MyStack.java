package ua.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Стек в домашніх умовах
*/

public class MyStack {

    private final List<String> storage = new ArrayList<>();

    public void push(String s) {
        //напишіть тут ваш код
        storage.add(0,s);

    }

    public String pop() {
        String res = storage.get(0);
        storage.remove(0);
    return res;}

    public String peek() {
        //напишіть тут ваш код
        return storage.get(0);}

    public boolean empty() {

        //напишіть тут ваш код
    return  storage.isEmpty();}

    public int search(String s) {
        //напишіть тут ваш код
        int res = storage.indexOf(s);
        return res;}
}
