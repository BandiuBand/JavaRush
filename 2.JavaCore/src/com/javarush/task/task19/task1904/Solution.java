package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(s);
        Person p = personScannerAdapter.read();
        personScannerAdapter.close();
        System.out.println(p.toString());
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter (Scanner scanner)
        {
            this.fileScanner = scanner;
        }
        @Override
        public Person read() throws IOException {
            String linePerson = fileScanner.nextLine();
            String[] parsedLine = parseLine(linePerson);
            return createPerson(parsedLine);
        }
        private String[] parseLine (String line)
        {
            String[] parsedLine = line.split(" ");
            return parsedLine;
        }
        private Person createPerson (String[] data)
        {
            String[] nn = Arrays.copyOfRange(data,3,6);
            Date birthday = parseBirthday(nn);

            return new Person(data[1],data[2],data[0],birthday);
        }
        private Date parseBirthday(String[] data)
        {
            GregorianCalendar birthday = new GregorianCalendar(Integer.parseInt(data[2]),(Integer.parseInt(data[1])-1),Integer.parseInt(data[0]));
            Date birt = birthday.getTime();
            return birt;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
