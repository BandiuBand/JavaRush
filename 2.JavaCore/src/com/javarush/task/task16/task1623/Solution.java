package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        @Override
        public void run()
        {
            if (createdThreadCount < Solution.count)
            {
                System.out.println((new GenerateThread()).toString());

            }
        }

        public GenerateThread ()
        {

            super(String.valueOf(++createdThreadCount));
            this.start();
            try {
                this.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
