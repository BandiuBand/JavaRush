package ua.javarush.task.pro.task11.task1107;

/* 
Двигун — серце автомобіля
*/

public class Car {
    //напишіть тут ваш код
Engine engine;
    public class Engine
    {
        private boolean isRunning = false;
        public void start ()
        {
            isRunning = true;
        }

        public void stop ()
        {
            isRunning = false;
        }


        
    }
    
    public static void main (String[] arg)
    {
       // Car a = new Car();
        Car a = new Car();

        Engine engine = a.new Engine();

        engine.start();
        engine.stop();

    }

}
