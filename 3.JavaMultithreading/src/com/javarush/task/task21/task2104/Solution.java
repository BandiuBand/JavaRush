package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Solution) {
            if ((first == null && ((Solution) o).first==null)&&(last == null)&&(((Solution) o).last==null))
                return true;
            if ((first == null && ((Solution) o).first==null))
            {
                return ((Solution) o).last.equals(this.last);
            } else if ((last == null)&&(((Solution) o).last==null)) {
                return ((Solution) o).first.equals(this.first);
            }
            else
            return ((Solution) o).first.equals(this.first) && ((Solution) o).last.equals(this.last);
        }
        return false;
    }

    public int hashCode() {
        int firs;
        int las;
        if (first == null)
            firs=0;
        else
            firs = first.hashCode();
        if (last == null)
            las=0;
        else
            las = last.hashCode();
        return 31 * firs + las;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, "Duck"));
        Solution one =new Solution(null, "Duck");
        boolean if_contains =s.contains(one);
        System.out.println(if_contains);
    }
}
