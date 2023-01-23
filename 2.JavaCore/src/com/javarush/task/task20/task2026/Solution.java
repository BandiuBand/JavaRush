//package com.javarush.task.task20.task2026;
//
///*
//Алгоритмы-прямоугольники
//*/
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution {
//    public static void main(String[] args) {
//        byte[][] a1 = new byte[][]{
//                {1, 1, 0, 0},
//                {1, 1, 0, 0},
//                {1, 1, 0, 0},
//                {1, 1, 0, 1}
//        };
//        byte[][] a2 = new byte[][]{
//                {1, 0, 0, 1},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {1, 0, 0, 1}
//        };
//
//        int count1 = getRectangleCount(a1);
//        System.out.println("count = " + count1 + ". Должно быть 2");
//        int count2 = getRectangleCount(a2);
//        System.out.println("count = " + count2 + ". Должно быть 4");
//    }
//
//    public static int getRectangleCount(byte[][] a) {
//        SqereS.b = a;
//        List<SqereS> fig= new ArrayList<>();
//        for (int x = 0; x < a[0].length; x++) {
//            for (int y = 0; y < a.length; y++) {
//                if (a[y][x]==1 && !isHaveFiendedFig(x,y,fig))
//                    fig.add(new SqereS(x,y));
//            }
//        }
//
//        return fig.size();
//    }
//    private static boolean isHaveFiendedFig(int x,int y,List<SqereS> fig)
//    {   if (fig==null || fig.size()==0)
//        return false;
//        for (SqereS sq:fig) {
//           if  (sq.isThisFig(x,y))
//               return true;
//        }
//        return false;
//    }
//    private static class SqereS
//    {
//        private static byte[][] b;
//
//        private int width  = 0;
//        private int heigh  = 0;
//        private int xStart = 0;
//        private int xEnd   = 0;
//        private int yStart = 0;
//        private int yEnd   = 0;
//
//        public SqereS(int x, int y)
//        {
//            //this.b=b;
//            xStart=x;
//            yStart=y;
//            fiendCoord();
//        }
//        private void fiendCoord()
//        {
//            this.xEnd = fiendOneLinCoord(b[yStart],xStart);
//            this.yEnd = fiendOneLinCoord(getEnotherLine(b,yStart),yStart);
//        }
//        public boolean isThisFig (int x,int y)
//        {
//            return (x >= xStart && x<= xEnd)&&(y >= yStart && y <= yEnd);
//        }
//        private byte[] getEnotherLine(byte[][] b,int y)
//        {   byte[] re = new byte[b.length];
//            for (int i = 0; i < b.length; i++) {
//                re[i] = b[i][y];
//            }
//            return re;
//        }
//        private int fiendOneLinCoord(byte[] b, int start)
//
//        {
//            for (int i = start; i <= b.length; i++) {
//                if (i == b.length)
//                    return i-1;
//                if (b[i]==0)
//                    return i-1;
//            }
//        return start;
//        }
//
//    }
//}




package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] arr) {
        byte[][] a = new byte[arr.length][arr[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = arr[i][j];
            }
        }

        int hor = a[0].length;
        int ver = a.length;
        int count;
        int verEnd;
        int horEnd;
        int result = 0;
        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < hor; j++) {
                if (a[i][j] == 1) {
                    verEnd = i;
                    horEnd = j;
                    //по вертикали
                    count = i + 1;
                    System.out.println("a[" + count + "][" + j + "]");
                    while (true) {
                        if (count >= ver || (a[count][j] == 0 && count < ver)) {
                            verEnd = count - 1;
                            System.out.println("verEnd = " + verEnd);
                            break;
                        }
                        count++;
                        System.out.println("a[" + count + "][" + j + "]");
                    }
                    //по горизонтали
                    count = j + 1;
                    while (true) {
                        if (count >= hor || (a[i][count] == 0 && count < hor)) {
                            horEnd = count - 1;
                            System.out.println("horEnd = " + horEnd);
                            break;
                        }
                        count++;
                    }
                    boolean flag = true;
                    for (int p = i; p <= verEnd; p++)
                        for (int q = j; q <= horEnd; q++)
                            if (a[p][q] != 1) {
                                flag = false;
                                break;
                            }
                    if (flag) {
                        System.out.println("startI = " + i);
                        System.out.println("startJ = " + j);
                        System.out.println("endI = " + verEnd);
                        System.out.println("endJ = " + horEnd);
                        for (int p = i; p <= verEnd; p++)
                            for (int q = j; q <= horEnd; q++)
                                a[p][q] = 0;
                        result++;
                    }
                    System.out.println();
                }
            }
        }
        return result;
    }
}
