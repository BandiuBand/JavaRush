package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args)  {

        System.out.println(new Solution(4));
        Solution saveObject = new Solution(0);
        Solution loadedObject = null;
        try {FileOutputStream fileOutputStream = new FileOutputStream("c:\\2\\1.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject((Object) saveObject);
            fileOutputStream.flush();
            fileOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream("c:\\2\\1.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            loadedObject = (Solution) inputStream.readObject();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(saveObject.string.equals(loadedObject.string));

    }

    transient  private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
