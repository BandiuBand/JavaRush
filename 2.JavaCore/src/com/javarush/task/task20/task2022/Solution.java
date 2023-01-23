package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);

    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName,true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
    try (FileOutputStream fileOutputStream = new FileOutputStream("c:\\2\\1.txt");
         FileInputStream fileInputStream = new FileInputStream("c:\\2\\1.txt");

         ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
         ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);){


        Solution s = new Solution("c:\\2\\2.txt");
        s.writeObject("2353426623654364274624\n");

        outputStream.writeObject(s);

        outputStream.flush();


        Solution m =  (Solution)inputStream.readObject();
        m.writeObject("111214321445125125215");

    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    }
}
