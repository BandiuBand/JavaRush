package com.javarush.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }


    /*
1. ������ 2 ���������� � ��������� ������:
        1.1) Item � �������� int getId(), double getPrice(), String getTM()
        1.2) Jeans extends Item � �������� int getLength() � int getSize()

        2. � ������ Util � ������ getAllJeans ������ ����������� ����� java-����:
        2.1) ��������� � ���, ��� ��� ���� � ������ getAllJeans ������ Util
        2.2) ������ ����������� class AbstractJeans �� ���������� Jeans � ����� ����������� �������, �������� ��������� ������
        2.3) ������ ������ Levis � Denim �� AbstractJeans, �������� ���������� �����
        2.4) � ������ AbstractJeans �������� ����� toString() (������ ��������������� Alt+Insert -> toString())
        2.5) ����� toString ������ AbstractJeans ������ ���������� � ����� ���������, ��������, Levis{id=1, length=34, size=6, price=150.0}

*/
    public static List<Jeans> getAllJeans() {

        //add your code here
        abstract class AbstractJeans implements Jeans
        {   private int id;
            private int length;
            private int size;
            private double price;



            public AbstractJeans(int id, int length, int size, double price) {
                this.id = id;
                this.length = length;
                this .size = size;
                this.price = price;
            }
            public abstract String getTM();
            public String toString(){
                StringBuilder sb = new StringBuilder();
                sb.append(this.getClass().getSimpleName());
                sb.append(String.format("{id=%d, length=%d, size=%d, price=%.1f}",id,length,size,price));
                return sb.toString();
            }

            @Override
            public int getId() {
                return id;
            }

            @Override
            public int getLength() {
                return length;
            }

            @Override
            public int getSize() {
                return size;
            }

            @Override
            public double getPrice() {
                return price;
            }
        }
        class Levis extends AbstractJeans
        {

            public Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return "Levis";
            }
        }
        class Denim extends AbstractJeans
        {

            public Denim(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return "Denim";
            }
        }


        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else if (Company.Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else {
                jeans = new AbstractJeans(id, length, size, price) {
                    @Override
                    public String getTM() {
                        return null;
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;

        Company(String name) {
            this.fullName = name;
        }
    }
}
