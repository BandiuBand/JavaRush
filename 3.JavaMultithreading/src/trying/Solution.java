package trying;

import java.util.regex.Pattern;
/*
ƒв≥йково-ш≥стнадц€тковий конвертер
*/
public class Solution {
    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("ƒв≥йкове число " + binaryNumber + " дор≥внюЇ ш≥стнадц€тковому числу " + toHex(binaryNumber));
                String hexNumber = "9d0";

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String number = Integer.toString(i,16);
            Boolean flag = toBinary(hexNumber).equals(Integer.toBinaryString(Integer.parseInt(hexNumber,16)));
            System.out.println(i);
            if (flag == false) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Number in HEX -- > " + number);
                System.out.println("Number in DEC -- > " + i);
                System.out.println("Number in BIN              -- > " + Integer.toBinaryString(i));
                System.out.println("Number in Your toBin       -- > " + toBinary(number));
                System.out.println("------------------------------------------------------------");
            }
        }

    }
    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.equals("")){
            return "";
        }
        int tennumber = 0;
        int index = binaryNumber.length()-1;
        char[] array = binaryNumber.toCharArray();
        for (int i = 0; i < binaryNumber.length(); i++) {
            int binary = 0;
            if (array[index] == '1'){
                binary = 1;
            }
            tennumber += + binary * Math.pow(2,i);
            index--;
            if (index < 0){
                break;
            }
        }
        String hex = "";
        String[] HEX = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        int indextwo = 0;
        while (tennumber != 0){
            indextwo = tennumber%16;
            hex = HEX[indextwo] + hex;
            tennumber = tennumber/16;
        }
        return hex;
    }
    public static String toBinary(String hexNumber) {
        if (hexNumber == null){
            return "";
        }
        String text = hexNumber.toLowerCase();
        if (text.equals("") || text == null ) {
            return "";
        }
        for (int w = 0; w < text.length(); w++) {
            if ((text.charAt(w) > '9' || text.charAt(w) < '0') && (text.charAt(w) < 'a' ||
                    text.charAt(w) > 'f')){
                return "";
            }
        }
        int decimal = 0;
        String HEX = "0123456789abcdef";
        for (int i = 0; i < text.length(); i++) {
            char index = text.charAt(i);
            int sixteen = HEX.indexOf(index);
            decimal = 16 * decimal + sixteen;
        }
        String hextwo = "";
        while (decimal != 0) {
            hextwo = decimal % 2 + hextwo;
            decimal = decimal / 2;
        }
        return hextwo;
    }
}