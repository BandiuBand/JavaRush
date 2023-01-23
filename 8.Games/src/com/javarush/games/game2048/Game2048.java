package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game
{
    private static final int SIDE = 4;
    private  int[][] gameField = new int[SIDE][SIDE];
    @Override
    public void initialize()
    {
        setScreenSize (SIDE,SIDE);
        createGame();
        drawScene();
    }
    private void drawScene()
    {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColor(i,j,Color.BLUE);
            }
        }
    }

    private void createNewNumber()
    {   boolean f = false;
        int x=0;
        int y=0;
        while(f == false)
        {
             x = getRandomNumber(SIDE);
             y = getRandomNumber(SIDE);
            if (gameField[y][x] == 0)
                f = true;
        }
        gameField[y][x]=getRandomNumber(10)<9?2:4;
    }
    private void createGame()
    {
        createNewNumber();
        createNewNumber();
        //drawScene();
       //Apple appl = new Apple(7,7);
        //appl.draw(this);
    }

}