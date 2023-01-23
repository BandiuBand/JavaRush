package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Знакомство с тегами
*/

public class Solution {
    private static List<String> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String path = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            path = bufferedReader.readLine();
        }
        String file = read(path);
        file = file.replaceAll("[\\n\\r]", "");
        SubLineTeg.file=file;
//        System.out.println(file);
        List<Integer> openTegIndexs = fiendOpenTeg(file, args[0]);
        List<Integer> closeTegIndexs = fiendCloseTeg(file, args[0]);
        //System.out.println(openTegIndexs);
        //System.out.println(closeTegIndexs);

        TreeSet<Teg> tegs= new TreeSet<Teg>();
        openTegIndexs.forEach(x->tegs.add(new Teg(true,x)));
        closeTegIndexs.forEach(x->tegs.add(new Teg(false,x)));

//        tegs.forEach(x->{
//            System.out.println(x.isOpen + "  " + x.position);
//        });

         List<SubLineTeg> subLineTegs = fiendParas(tegs);
        for (SubLineTeg sub:subLineTegs) {
            System.out.println(sub.toString());
            }
    }

    private static List<SubLineTeg> fiendParas(TreeSet<Teg> tegs)
        {   List<SubLineTeg> listSublines = new ArrayList<>();
            while (!(tegs.isEmpty())) {
                Teg openTeg = tegs.first();
                Teg closeTeg = fiendPara(tegs);
                tegs.remove(openTeg);
                tegs.remove(closeTeg);
                SubLineTeg subLineTeg = new SubLineTeg(openTeg.position,closeTeg.position);
                //System.out.println(subLineTeg.toString());
                //System.out.println(openTeg.getPosition()+ "  "  +closeTeg.getPosition());
                listSublines.add(subLineTeg);
            }
            return listSublines;
        }

    private static Teg fiendPara(TreeSet<Teg> tegs)
    {       Teg firstOpenTeg = tegs.first();
            firstOpenTeg.setLevel(0);
            tegs.remove(firstOpenTeg);
            int level = firstOpenTeg.getLevel();
        for (Teg x: tegs) {
            if (!((!x.isOpen()) && (x.getLevel()==level)))
            {
                if (x.isOpen)
                     level++;
                else level--;
            }
            else
                return x;
            }
        return new Teg(false,0);
    }
    private static List<Integer> fiendOpenTeg(String file, String teg) {
        List<Integer> index = new ArrayList<>();
        int ind = -1;
        while (true) {
            ind = file.indexOf("<" + teg, ind + 1);
            if (ind < 0)
                return index;
            index.add(ind);
        }
    }

    private static List<Integer> fiendCloseTeg(String file, String teg) {
        List<Integer> index = new ArrayList<>();
        int ind = -1;
        while (true) {
            ind = file.indexOf("/" + teg + ">", ind + 1);
            if (ind < 0)
                return index;
            index.add(ind + teg.length() + 1);
        }
    }

    private static String read(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            if (bufferedReader.ready())
                stringBuilder.append(bufferedReader.readLine());
            while (bufferedReader.ready()) {
                stringBuilder.append('\n').append(bufferedReader.readLine());
            }

        }
        String result = stringBuilder.toString();
        return result;
    }
    private static class Teg implements Comparable<Teg>
    {
        private boolean isOpen;
        private int level = 0;
        private int position;
        public Teg(boolean isOpen,int position)
        {
            this.isOpen = isOpen;
            this.position = position;
        }
        public boolean isEqualLevel(Teg teg)
        {
            return teg.level == this.level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public int getLevel() {
            return level;
        }

        public int getPosition() {
            return position;
        }
        public int compareTo (Teg teg)
        {
            return this.position-teg.position;
        }
    }

    private static class SubLineTeg {

        private static String file;
        private String resTeg;

        public SubLineTeg(int st,int end) {
            this.resTeg = file.substring(st,end+1);
        }
        @Override
        public String toString()
        {
            return this.resTeg;
        }
    }
}