package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new One());
        threads.add(new Two());
        threads.add(new Third());
        threads.add(new Forth());
        threads.add(new Fifth());
    }

    public static void main(String[] args) throws InterruptedException {

       





    }
    public static class One extends Thread
    {
        public void run() {

            while (true)
            {

            }
        }
    }
    public static class Two extends Thread
    {
        @Override
        public void run() {
            try {
                while (!isInterrupted())
                Thread.sleep(1000);
                throw new InterruptedException("InterruptedException");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }



    }
    public static class Third extends Thread
    {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {

                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                }
        }
    }
    public static class Forth extends Thread implements Message
    {   private boolean f  = false;

        @Override
        public void run() {
            while (!f) {
              //  try {
                    //Thread.sleep(1);
               // } catch (InterruptedException e) {
               //     throw new RuntimeException(e);
               // }
            }
        }

        @Override
        public void showWarning() {
            f = true;
        }
    }
    public static class Fifth extends Thread
    {
        @Override
        public void run() {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
                int Sum = 0;
                String number;
                while (!(number = bufferedReader.readLine()).equals("N"))
                {
                   Sum +=Integer.parseInt(number);
                }
                System.out.println(Sum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}