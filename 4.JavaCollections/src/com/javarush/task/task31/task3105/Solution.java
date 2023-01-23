package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = "c:\\2\\abc.mp3";
        String archive = "c:\\2\\arhiv.zip";
        List<Cont> conts = getConts(archive);
        FileOutputStream zOutput = new FileOutputStream(archive);
        ZipOutputStream zipOutput = new ZipOutputStream(zOutput);
        File fil = new File(file);
        String name = "new/"+fil.getName();
        zipOutput.putNextEntry(new ZipEntry(name));
        Files.copy(fil.toPath(),zipOutput);

        for (Cont c:conts) {
            if (!c.getName().equals(fil.getName()))
            {
                c.save(zipOutput);
            }

        }
        zipOutput.flush();
        zipOutput.close();

    }
    public static List<Cont> getConts(String path)
    {   List<Cont> conts = new ArrayList<>();
        try (ZipInputStream zipInput = new ZipInputStream(new FileInputStream(path))) {
            ZipEntry entry = zipInput.getNextEntry();

            byte[] bufer = new byte[4048];
            int lengs;
            while ((entry=zipInput.getNextEntry())!=null)
            {   ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while ((lengs=zipInput.read(bufer))>0)
                    {
                    byteArrayOutputStream.write(bufer,0,lengs);
                    }
                conts.add(new Cont(entry.getName(), byteArrayOutputStream.toByteArray()));
            }
            return conts;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Cont
    {
        private String name;
        private byte[] entry;

        public Cont (String name,byte[] entry)
        {
            this.entry=entry;
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void save(ZipOutputStream zs)
        {
            try {
                zs.putNextEntry(new ZipEntry(this.name));
                zs.write(entry);
                zs.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//package com.javarush.task.task31.task3105;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//import java.util.zip.ZipOutputStream;
//
///*
//Добавление файла в архив
//*/
//
//public class Solution {
//
//    public static void main(String[] args) throws IOException {
//        List<Content> entries = getContents(args[1]);
//
//        FileOutputStream zipFile = new FileOutputStream(args[1]);
//        ZipOutputStream zip = new ZipOutputStream(zipFile);
//
//        //кладем в него  ZipEntry –«архивный объект»
//        File file = new File(args[0]);
//        zip.putNextEntry(new ZipEntry("new/" + file.getName()));
//
//        //копируем файл «document-for-archive.txt» в архив под именем «document.txt»
//        Files.copy(file.toPath(), zip);
//
//        //копируем все остальные файлы
//        for (Content content : entries) {
//            if (!content.getFileName().equals("new/" + file.getName())) content.saveToZip(zip);
//        }
//
//        // закрываем архив
//        zip.close();
//    }
//
//    private static List<Content> getContents(String arg) throws IOException {
//        List<Content> entries = new ArrayList<>();
//        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(arg))) {
//            ZipEntry currentEntry;
//            byte[] buffer = new byte[1024];
//            while ((currentEntry = zipInputStream.getNextEntry()) != null) {
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                int length = 0;
//                while ((length = zipInputStream.read(buffer)) > 0) {
//                    outputStream.write(buffer, 0, length);
//                }
//                entries.add(new Content(currentEntry.getName(), outputStream.toByteArray()));
//            }
//        }
//        return entries;
//    }
//
//    static class Content {
//        String fileName;
//        byte[] body;
//
//        Content(String fileName, byte[] body) {
//            this.fileName = fileName;
//            this.body = body;
//        }
//
//        public String getFileName() {
//            return fileName;
//        }
//
//        void saveToZip(ZipOutputStream zip) throws IOException {
//            ZipEntry zipEntry = new ZipEntry(fileName);
//            zip.putNextEntry(zipEntry);
//            zip.write(body);
//            zip.closeEntry();
//        }
//    }
//}
