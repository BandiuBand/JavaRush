package ua.javarush.task.pro.task10.task1003;

/* 
Збудуймо новий бізнес-комплекс JavaRush Business Center
*/

public class Skyscraper {
    private int floorsCount;
    private String developer;

    //напишіть тут ваш код
    public Skyscraper()
    {
        floorsCount = 5;
        developer = "JavaRushDevelopment";
    }
    public Skyscraper(int flors,String dev)
                {
        floorsCount = flors;
        developer = dev;
                }

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperUnknown = new Skyscraper(50, "Невідомо");
        //Skyscraper s = new Skyscraper();
    }
}
