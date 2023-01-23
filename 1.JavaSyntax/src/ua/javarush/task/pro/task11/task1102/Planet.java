package ua.javarush.task.pro.task11.task1102;

/* 
Земля: технічна характеристика
*/

public class Planet {

    public  String name;

    public  long age;

    public  int speed;

    public  int area;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(long age)
    {
        this.age = age;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void setArea (int area)
    {
        this.area = area;
    }

    public void printInformation() {
        System.out.println("Ім'я планети: " + name + ".");
        System.out.println("Вік: " + age + " років.");
        System.out.println("Орбітальна швидкість: " + speed + " км/год.");
        System.out.println("Загальна площа: " + area + " кв. км.");
    }
}
