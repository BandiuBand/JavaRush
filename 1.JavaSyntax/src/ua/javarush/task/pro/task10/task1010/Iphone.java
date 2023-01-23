package ua.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфони
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }
@Override
    public boolean equals(Object second)
    {
        if ((this == null) || (this.model == null)||(this.color==null))
        return false;
        if (second == (null))
        return false;
          if (!(second instanceof Iphone))
        return false;
      Iphone sec = (Iphone) second;
if ((sec.model == null) || (sec.color == null))
    return false;
    if ((this.model.equals(sec.model)) && (this.color.equals(sec.color))
    &&(this.price == sec.price))
    return true;
    else
    return false;
    }

    //напишіть тут ваш код

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("x", "Black", 999);
        Iphone iphone2 = new Iphone("x", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    
    }
}

