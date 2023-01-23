package com.javarush.games.moonlander;
import com.javarush.engine.cell.*;
public class MoonLanderGame extends Game
{
    public static final int WIDTH = 64;
    public static final int  HEIGHT = 64;
    //rivate boolean gotovo = false;
    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        createGame();



    }
    private void createGame()
    {
        drawScene();
    }
    private void drawScene()
    {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                setCellColor(i, j, Color.ORANGE);
            }
        }

    }
}
