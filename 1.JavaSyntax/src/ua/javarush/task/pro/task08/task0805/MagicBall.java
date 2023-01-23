package ua.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Безперечно";
    private static final String DEFINITELY = "Безумовно, так";
    private static final String MOST_LIKELY = "Найймовірніше";
    private static final String OUTLOOK_GOOD = "Хороші перспективи";
    private static final String ASK_AGAIN_LATER = "Запитай пізніше";
    private static final String TRY_AGAIN = "Спробуй ще";
    private static final String NO = "Моя відповідь — ні";
    private static final String VERY_DOUBTFUL = "Вельми сумнівно";

    public static String getPrediction() {
        //напишіть тут ваш код
        Random r = new Random();
        int a = r.nextInt(8);
        if (a == 0)
            return CERTAIN;
        if (a == 1)
            return DEFINITELY;
        if (a == 2)
            return MOST_LIKELY;
        if (a == 3)
            return OUTLOOK_GOOD;
        if (a == 4)
            return ASK_AGAIN_LATER;
        if (a == 5)
            return TRY_AGAIN;
        if (a == 6)
            return NO;
        if (a == 7)
            return VERY_DOUBTFUL;
        return null;
    }
}
