package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] sol = new Solution[2];
        sol[0] = new Solution();
        sol[1] = new Solution();
        Solution one = sol[0];
        Solution two = sol[1];
        one.innerClasses[0] = one.new InnerClass();
        two.innerClasses[0] = two.new InnerClass();
        one.innerClasses[1] = one.new InnerClass();
        two.innerClasses[1] = two.new InnerClass();


        return sol;
    }

    public static void main(String[] args) {

    }
}
