package ua.javarush.task.pro.task09.task0918;

/* 
Попрацюймо зі StringBuilder
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Навчатися, навчатися і ще раз навчатися! ";

        System.out.println(addTo(string, new String[]{"Під ", "лежачий ", "камінь ", "вода ", "не ", "тече"}));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder addTo(String string, String[] strings) {
        //напишіть тут ваш код
        StringBuilder str = new StringBuilder();
        str.append(string);
        for (int i = 0; i < strings.length; i++) {
              str.append(strings[i]);
        }
        return str;
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        //напишіть тут ваш код
        StringBuilder stri = new StringBuilder();
        stri.append(string);
        stri.replace (start, end, str);
        return stri;
    }
}
