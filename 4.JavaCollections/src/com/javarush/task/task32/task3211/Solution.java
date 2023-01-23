package com.javarush.task.task32.task3211;

import javax.xml.datatype.DatatypeConstants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
            MessageDigest newMD5 = MessageDigest.getInstance("MD5");

            byte[] result = newMD5.digest(byteArrayOutputStream.toByteArray());
            String re = new String(result);
            StringBuilder sb = new StringBuilder(result.length * 2);
            for(byte b: result) {
            sb.append(String.format("%02x", b));
            }
            return sb.toString().equals(md5);
    }
}
