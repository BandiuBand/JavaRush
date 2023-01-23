package ua.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor>{
    @Override
    public int compare(JavaRushMentor o1, JavaRushMentor o2) {
        int lens1 = o1.getName().length();
        int lens2 = o2.getName().length();

        if (lens1<lens2)
            return -1;
        else if (lens2<lens1)
            return 1;
        else
            return 0;

    }
    //напишіть тут ваш код
}
