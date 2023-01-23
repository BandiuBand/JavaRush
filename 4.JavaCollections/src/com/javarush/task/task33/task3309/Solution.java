package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(obj,stringWriter);
        String result = stringWriter.toString();
//        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
//                "<first>\n" +
//                "<second>some string</second>\n" +
//                "<second>some string</second>\n" +
//                "<second><![CDATA[need CDATA because of < and >]]></second>\n" +
//                "<second/>\n" +
//                "</first>";
        String teg = "<"+ tagName + ">";
        String com = "<!--"+comment+"-->"+"\n"+teg;
        String resultat = result.replaceAll(teg,com);
        return resultat;
    }

    public static void main(String[] args) throws JAXBException {
        Solution s= new Solution();
        System.out.println(toXmlWithComment(s, "second", "it's a comment"));
    }
}
