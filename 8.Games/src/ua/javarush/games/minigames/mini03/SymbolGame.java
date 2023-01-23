package ua.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

import java.util.Arrays;

/*
Проста програма
*/

public class SymbolGame extends Game {
    @Override
    public void initialize()
    {

        setScreenSize(8,3);


        //showGrid(false);
        Writer();

    }
    private void Writer ()
    {
        String word = "JAVARUSH";
        char[] chWordArr = word.toCharArray();
        int leng = chWordArr.length;
        for (int i = 0; i < leng; i++)
        {
            setCellValueEx(i,1,Color.ORANGE,String.valueOf(chWordArr[i]));
        }
    }
    //напишіть тут ваш код
}
