package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            String your_file_name = "c:\\2\\1.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);


            Human ivanov = new Human("Ivanov",null); //new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();
            Human somePerson = new Human();
            InputStream inputStream = new FileInputStream(your_file_name);
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return false;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (this.hashCode() != human.hashCode()) return false;
            else if (name.equals(human.name) && (equalsList(assets,human.assets))) {
                return true;
            } else
            return false;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.toString().hashCode() : 0;
            result = 31 * result + (assets != null ? hashCodeAs(assets) : 0);
            return result;
        }

        public boolean equalsList(List<Asset> assets1,List<Asset> assets2)
        {
            if ((assets1 == null && assets2 == null))
                return true;
            else if ((assets1 == null)||(assets2==null))
                return false;
            if (assets1.size()!=assets2.size())
            return false;
            else
            {
                for (int i = 0; i < assets1.size(); i++) {
                    if(!assets1.get(i).equals(assets2.get(i)))
                        return false;
                }
            }
            return true;
        }
        private int hashCodeAs(List<Asset> assets)
        { int sum =0;
            for (Asset as:assets) {
                sum +=as.hashCode();
            }
            return sum;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
            else this.assets=null;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(this.name);
            if (this.assets != null) {
                printWriter.println("not null");
                for (Asset current : this.assets)
                    printWriter.println(current.getName());
            }
            else {printWriter.println("null");}
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            this.name = reader.readLine();
            boolean isNull = reader.readLine().equals("null")?true:false;
            if (isNull)
                this.assets=null;
            else {
            String assetName;
            while ((assetName = reader.readLine()) != null)
                this.assets.add(new Asset(assetName));}
            reader.close();
        }
    }
}
