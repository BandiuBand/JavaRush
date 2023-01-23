package ua.javarush.task.pro.task14.task1416;

/* 
Трасування стека
*/

public class Solution {

    public static void main(String[] args) {
        try {
            dangerousMethod();
        }
        catch (Exception e)
        {
           // StackTraceElement el = e.getStackTrace()[];
            e.printStackTrace();
        }

    }

    static void dangerousMethod() throws Exception {
        throw new Exception("Mu-ha-ha!");
    }
}
