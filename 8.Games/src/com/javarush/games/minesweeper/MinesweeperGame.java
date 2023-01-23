package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;
    private int countFlags;
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();

    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        isGameStopped = false;
    }
    private void gameOver()
    {
        isGameStopped = true;
        showMessageDialog(Color.WHITE,"GAME OVER",Color.RED,80);
    }
    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors()
    {
        //int[][] coun = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE;j++) {
                if (gameField[i][j].isMine)
                    continue;
                List<GameObject> list = getNeighbors(gameField[i][j]);
                AtomicInteger result = new AtomicInteger();
                list.forEach((x)->{
                    if (x.isMine)
                        result.getAndIncrement();
                });
                gameField[i][j].countMineNeighbors = result.intValue();
                //coun[i][j] = gameField[i][j].countMineNeighbors;
            }

        }

    }

    private void openTile(int x, int y)
    {
        GameObject thIs = gameField[y][x];
        if (thIs.isMine)
        {
            setCellValueEx(x,y,Color.RED,MINE);
            gameOver();
            return;
        }
        int thX = x;
        if (thIs.isOpen ||
            thIs.isFlag ||
                isGameStopped)
            return;
        if(! thIs.isMine)
        {
            thIs.isOpen = true;
            if (thIs.countMineNeighbors != 0)
                setCellNumber(x,y,thIs.countMineNeighbors);
            else
            {
                List<GameObject> Neighbors =new ArrayList<>(getNeighbors(thIs));
                for (GameObject obj:Neighbors) {

                    openTile(obj.x, obj.y);
                }
                setCellValue(x,y,"");
            }
            setCellColor(x,y,Color.GREEN);
            return;
        }
        if(thIs.isMine = true)
        {
            thIs.isOpen = true;
            setCellValue(x,y,MinesweeperGame.MINE);
        }
    }

    private void markTile(int x, int y)
    {
        if (isGameStopped == true)
            return;
        if ((gameField[y][x].isOpen) ||
                ((countFlags == 0) &&
                    (gameField[y][x].isFlag==false)))
            return;
        if (gameField[y][x].isFlag == false) {
            gameField[y][x].isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        }
            else
            {
                setCellValue(x, y, "");
                setCellColor(x,y,Color.ORANGE);
                gameField[y][x].isFlag = false;
                countFlags++;
            }



    }
    @Override
    public void onMouseLeftClick(int x, int y)
    {
        openTile(x,y);
    }
    @Override
    public void onMouseRightClick(int x, int y)
    {
        markTile(x,y);
    }



    //    public ArrayList<GameObject> getNeighbors (GameObject gameObject)
//    { ArrayList<GameObject> list = new ArrayList<>();
//        int x = gameObject.x;
//        int y = gameObject.y;
//        for (int i = (x-1); i <=(x+1) ; i++) {
//            for (int j = (y-1); j <=(y+1) ; j++) {
//                if ((i == x)&&(j == y) ||
//                        (i<0) || (i>MinesweeperGame.SIDE) ||
//                        (j<0) || (j>MinesweeperGame.SIDE))
//                {
//                    list.add(gameField[j][i]);
//                }
//            }
//        }
//        return list;
//    }
}