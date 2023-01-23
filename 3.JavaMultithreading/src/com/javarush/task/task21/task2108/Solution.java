package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        @Override
        public int hashCode() {
            return 31 * super.hashCode() + branches.hashCode();
        }


        public boolean equals(Tree obj) {
            if (!(obj instanceof Tree))
                return false;
            if (obj == this)
                return true;
            if (obj == null && this == null)
                return true;
            if ((obj == null && this!= null)||(obj != null && this== null))
                return false;
            if (  ((obj.getName() == null) || (this.getName() == null))   &&   !((obj.getName() == null) && (this.getName() == null)) )
                return false;
            if (!(obj.getName()).equals(this.getName()))
                return false;
            if (  ((obj.branches == null) || (this.branches == null))   &&   !((obj.branches == null) && (this.branches == null)) )
                    return false;
            if (!obj.getName().equals(this.getName()) || !equalsBrances(this.branches,obj.branches))
                return false;

            return true;
        }
        public boolean equalsBrances(String[] srtAr,String[] srrAr1)
        {
            if (srrAr1.length != srtAr.length)
                return false;
            for (int i = 0; i < srrAr1.length; i++) {
                if (srrAr1[i].equals(srtAr[i]))
                    return false;
            }
            return true;

            }


        @Override
        protected Tree clone() throws CloneNotSupportedException {
            int leng = this.getBranches().length;
            String[] bre = this.getBranches();
            String[] newStr = new String[leng] ;
            System.arraycopy(bre,0,newStr,0,leng);
            Tree newTree = new Tree(this.getName(),newStr);
            return newTree;
        }

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
