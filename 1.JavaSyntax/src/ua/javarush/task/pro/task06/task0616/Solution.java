package ua.javarush.task.pro.task06.task0616;

/* 
Облік працівників
*/

public class Solution {
    public  final String name = "Amigo";
    public  String position = "Java developer";
    public  int salary = 10_000;

    public  void setPosition(String position)
    {
        this.position = position;
    }

    public void main(String[] args) {
        setPosition("chif engener");
        setSalary(7000);
        System.out.println(name +" of position " + position + " " +" have salary " + salary + "$");
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}
