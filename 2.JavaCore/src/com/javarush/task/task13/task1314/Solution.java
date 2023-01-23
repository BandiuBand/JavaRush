package com.javarush.task.task13.task1314;

import java.awt.*;

/*
Большая лисица — это такая лисица
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BigFox bigFox = new BigFox();
        System.out.println(BigFox.getName());
        System.out.println(bigFox.getColor());

    }

    public interface Animal {
        Color getColor();
    }

    public static abstract class Fox implements Animal {
        public static String getName() {
            return "Fox";
        }
    }

    public static class BigFox extends Fox{
        public Color color() {
            return Color.GRAY;
        }
        public Color getColor()
        {
            return color();
        }

    }

}
