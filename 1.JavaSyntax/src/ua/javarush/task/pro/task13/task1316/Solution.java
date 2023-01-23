package ua.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        //напишіть тут ваш код
        JavarushQuest[] questAr = JavarushQuest.values();
        for (JavarushQuest quest: questAr)
             {
                 System.out.println(quest.ordinal());
             }
        }
}
