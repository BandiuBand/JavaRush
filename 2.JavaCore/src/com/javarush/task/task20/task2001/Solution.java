package com.javarush.task.task20.task2001;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String your_file_name = "c:\\2\\1.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.equals(ivanov));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Writer writer = new PrintWriter(outputStream);
            writer.write(this.name);
            writer.write("\n");
            if (this.assets == null)
            {
                writer.write("NULL");
                writer.write("\n");
            }
            else
            {
                writer.write("CONTINUE");
                writer.write("\n");
                assets.forEach(x-> {
                    try {
                        writer.write(x.writeAsest());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String con = "";
            BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            if ((con=reader.readLine()).equals("NULL\n"))
            {
                this.assets = null;
            } else if (con.equals("CONTINUE")) {
                String s = "";

                while ((s=reader.readLine())!=null && !s.equals("\n")) {
                    String name = s;
                    double price = Double.parseDouble(reader.readLine());
                    this.assets.add(new Asset(name,price));
                }
            }
            else throw new Exception();

        }
    }
}
