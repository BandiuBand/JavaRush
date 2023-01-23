package ua.javarush.task.pro.task11.task1101;

/* 
Сонячна система — наш дім
*/

public class Solution {

    public static void main(String[] args) {

        System.out.println("Людство живе в Сонячній системі.");
        System.out.println("Її вік близько "+ SolarSystem.age+" років.");
        System.out.println("У Сонячній системі " + SolarSystem.planetsCount + " відомих планет.");
        System.out.println("Так само, як і більшість зоряних систем, вона має " + SolarSystem.starsCount + " зорю.");
        System.out.println("Зорю на ім'я " + SolarSystem.starName + ".");
        System.out.println("Відстань до центра галактики становить " + SolarSystem.galacticCenterDistance + " світлових років.");
        System.out.println("Кожен мешканець Сонячної системи має знати цю інформацію!");

    }
}
