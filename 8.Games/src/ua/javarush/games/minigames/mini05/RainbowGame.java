package ua.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Кольори веселки
*/

public class RainbowGame extends Game {

    @Override
    public void initialize()
    {
        setScreenSize(10,7);
        Color[] arrColour = {
                Color.RED,
                Color.ORANGE,
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                Color.INDIGO,
                Color.VIOLET
        };
        for (int i = 0; i < getScreenHeight(); i++) {
            Color curentColour = arrColour[i];
            for (int j = 0; j < getScreenWidth(); j++) {
                setCellColor(j,i,curentColour);
            }
        }
    }
}
