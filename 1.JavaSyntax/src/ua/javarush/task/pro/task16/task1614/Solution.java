package ua.javarush.task.pro.task16.task1614;

import java.time.Instant;

/* 
Кінець часів
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        //напишіть тут ваш код

        return Instant.ofEpochMilli(Long.MAX_VALUE);
    }

    static Instant getMaxFromSeconds() {
        //напишіть тут ваш код

        return Instant.ofEpochSecond(31556889864403199L);
    }

    static Instant getMaxFromSecondsAndNanos() {
        //напишіть тут ваш код

        return Instant.ofEpochSecond(31556889864403199L, 999_999_999);

    }
}
