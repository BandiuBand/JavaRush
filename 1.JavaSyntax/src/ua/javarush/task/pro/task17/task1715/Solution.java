package ua.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вілларібо і Віллабаджо
*/

public class Solution {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        //напишіть тут ваш код
        orchestra.add(new Organ());
        for (int i = 0; i < 3; i++)
            orchestra.add(new Piano());
    }

    public static void createStringedOrchestra() {
        //напишіть тут ваш код
        for (int i = 0; i < 2; i++)
        {
            orchestra.add(new Violin());
        }
        orchestra.add(new Guitar());
    }

    public static void playOrchestra() {
        //напишіть тут ваш код
        for (MusicalInstrument instrument: orchestra)
        {
            instrument.play();
        }
    }
}
