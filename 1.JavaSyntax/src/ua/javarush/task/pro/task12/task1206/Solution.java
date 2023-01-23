package ua.javarush.task.pro.task12.task1206;

/* 
Аналіз рядків
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Гадаю, це буде нова фіча." +
                "Тільки нікому не кажіть, що вона виникла випадково.1";

        System.out.println("Кількість цифр у рядку : " + countDigits(string));
        System.out.println("Кількість літер у рядку : " + countLetters(string));
        System.out.println("Кількість пробілів у рядку : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        int leng = string.length();
        int count = 0;
        for (int i = 0; i < leng; i++) {
            if (Character.isDigit(string.charAt(i)))
                count ++;
        }
        //напишіть тут ваш код
        return count;
    }

    public static int countLetters(String string) {
        int leng = string.length();
        int count = 0;
        for (int i = 0; i < leng; i++) {
            if (Character.isLetter(string.charAt(i)))
                count ++;
        }
        //напишіть тут ваш код
        return count;
    }

    public static int countSpaces(String string) {
        int leng = string.length();
        int count = 0;
        for (int i = 0; i < leng; i++) {
            if (Character.isWhitespace(string.charAt(i)))
                count ++;
        }
        //напишіть тут ваш код
        return count;
    }
}
