package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String yourFile = "c:\\2\\1.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.OTHER);
            javaRush.users.get(0).setFirstName("Jane");
            javaRush.users.get(0).setLastName("Shicoruak");
            javaRush.users.get(0).setBirthDate((new GregorianCalendar(1993,5,15)).getTime());

            javaRush.users.get(1).setMale(true);
            javaRush.users.get(1).setCountry(User.Country.OTHER);
            javaRush.users.get(1).setFirstName("Jane");
            javaRush.users.get(1).setLastName("Shicoruak");
            javaRush.users.get(1).setBirthDate((new GregorianCalendar(1993,5,15)).getTime());

            javaRush.users.get(2).setMale(true);
            javaRush.users.get(2).setCountry(User.Country.UKRAINE);
            javaRush.users.get(2).setFirstName("Diana");
            javaRush.users.get(2).setLastName("Dianosaurik");
            javaRush.users.get(2).setBirthDate((new GregorianCalendar(1993,5,15)).getTime());

            javaRush.users.get(3).setMale(true);
            javaRush.users.get(3).setCountry(User.Country.OTHER);
            javaRush.users.get(3).setFirstName("Chishkau");
            javaRush.users.get(3).setLastName("Shicoruak");
            javaRush.users.get(3).setBirthDate((new GregorianCalendar(1993,5,15)).getTime());

            javaRush.users.get(4).setMale(true);
            javaRush.users.get(4).setCountry(User.Country.OTHER);
            javaRush.users.get(4).setFirstName("Anna");
            javaRush.users.get(4).setLastName("Shicoruak");
            javaRush.users.get(4).setBirthDate((new GregorianCalendar(1993,5,15)).getTime());



            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (User us:users) {



                    try {
                        String user = us.writeUser();
                        bufferedWriter.write(user);
                        bufferedWriter.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

            }
        }

        public User parseUser(String[] lines)
            {   String firstName = lines[0];
                String lastName  = lines[1];
                String dataBirSt = lines[2];
                String isMailStr = lines[3];
                String countrSt  = lines[4];
                Date dateBirstday= new Date(Long.parseLong(dataBirSt));
                boolean isMail   = Boolean.parseBoolean(isMailStr);
                User.Country country = User.Country.valueOf(countrSt);
                User user =  new User();
                user.setCountry(country);
                user.setBirthDate(dateBirstday);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setMale(isMail);
                return user;
            }
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true)
            {   String[] userLines = new String[5];
                for (int i = 0; i < 5; i++) {
                    String s = bufferedReader.readLine();
                    if (s==null || s.equals("\n"))
                        return;
                    else {
                        userLines[i] = s;
                    }
                }
                users.add(parseUser(userLines));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
