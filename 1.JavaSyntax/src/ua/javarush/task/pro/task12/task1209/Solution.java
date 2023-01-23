package ua.javarush.task.pro.task12.task1209;

import java.util.ArrayList;
import java.util.Scanner;

/* 
Бухгалтерія
*/

public class Solution {
    public static ArrayList<String> waitingEmployees = new ArrayList<>();
    public static ArrayList<String> alreadyGotSalaryEmployees = new ArrayList<>();

    public static void initEmployees() {
        waitingEmployees.add("Гвінно");
        waitingEmployees.add("Гунігерд");
        waitingEmployees.add("Боргелейф");
        waitingEmployees.add("Ніфрод");
        waitingEmployees.add("Альбіуф");
        waitingEmployees.add("Іногрім");
        waitingEmployees.add("Фріле");
    }

    public static void main(String[] args) {
        initEmployees();
       /* Scanner k = new Scanner(System.in);

        for (; ; ) {
            paySalary(k.nextLine());
        }

         */

    }

    public static void paySalary(String name) {
        if (name == null)
            return;

        if (waitingEmployees.contains(name))
        {   int index = 0;
            for (int i = 0; i < waitingEmployees.size(); i++) {
                if ((!(waitingEmployees.get(i) == null)) && waitingEmployees.get(i).equals(name))
                    {
                        index = i;
                        break;
                    }
            }
            if (!(alreadyGotSalaryEmployees.contains(name)))
            {
                alreadyGotSalaryEmployees.add(name);
                waitingEmployees.set(index,null);
            }
        }
        //напишіть тут ваш код

    }
}
