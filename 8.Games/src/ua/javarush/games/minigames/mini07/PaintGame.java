package ua.javarush.games.minigames.mini07;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Робота з мишею
*/

public class PaintGame extends Game {

    @Override
    public void initialize() {

        setScreenSize(5,5);
        for (int i = 0; i < getScreenWidth(); i++)
        {
            for (int j = 0; j < getScreenHeight(); j++) {
                setCellColor(i,j,Color.WHITE);
            }
        }
    }
@Override
    public void onMouseRightClick(int x,int y)
        {
            setCellColor(x,y,Color.ORANGE);
        }


    @Override
    public void onMouseLeftClick(int x,int y)
    {
        setCellColor(x,y,Color.GREEN);
    }


}
