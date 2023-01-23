package com.javarush.task.task19.task1903;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        IncomeData in = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 71112233;
            }
        };
        IncomeDataAdapter dataAdapter = new IncomeDataAdapter(in);
        System.out.println(dataAdapter.getCompanyName());
        System.out.println(dataAdapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data)
        {
            this.data = data;
        }
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return String.format("%s, %s",data.getContactLastName(),data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
//            char[] number = {'+','0','0','0','0','0','0','0','0','0','0','0','0'};
//            String phoneCod = String.valueOf(data.getCountryPhoneCode());
//            for (int i = 0; i < phoneCod.length(); i++) {
//                number[i+1] = phoneCod.charAt(i);
//            }
//            String phoneNumber = String.valueOf(data.getPhoneNumber());
//            for (int i = number.length-1; i > number.length-phoneNumber.length()-1; i--) {
//                number[i] = phoneNumber.charAt(i-(number.length-phoneNumber.length()));
//            }
//            StringBuilder k = new StringBuilder();
//            for (char c:number)
//                k.append(c);
//            k.insert(3,'(').insert(7,')').insert(11,'-').insert(14,'-');
//            return k.toString();
            String res = String.format("+%d(%2$s)%3$s-%4$s-%5$s", data.getCountryPhoneCode(),
                    String.format("%010d", data.getPhoneNumber()).substring(0, 3),
                    String.format("%010d", data.getPhoneNumber()).substring(3, 6),
                    String.format("%010d", data.getPhoneNumber()).substring(6, 8),
                    String.format("%010d", data.getPhoneNumber()).substring(8));

            return res;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}