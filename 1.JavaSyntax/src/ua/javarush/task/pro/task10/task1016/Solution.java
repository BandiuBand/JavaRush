package ua.javarush.task.pro.task10.task1016;

/* 
Прогноз погоди
*/

public class Solution {

    public static void showWeather(City city) {
        //напишіть тут ваш код
        String A=String.format("У місті %s сьогодні температура повітря %s",(city.getName()),(city.getTemperature()));
        System.out.println(A);
    }

    public static void main(String[] args) {
        //напишіть тут ваш код
        City city= new City("Odessa",22);
        showWeather(city);
    }
}
