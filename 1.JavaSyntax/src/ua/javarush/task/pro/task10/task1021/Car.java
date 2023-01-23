package ua.javarush.task.pro.task10.task1021;

/* 
Автовиробник
*/

public class Car {
    private String model;
    private int year;
    private String color;
public void initialize(String model,int year,String color)
{
    if (model != null)
    this.model = model;
    this.year = year;
    if (color != null)
    this.color = color;
}

    //напишіть тут ваш код

}
