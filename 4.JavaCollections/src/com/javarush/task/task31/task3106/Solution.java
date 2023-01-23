//package com.javarush.task.task31.task3106;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipFile;
//import java.util.zip.ZipInputStream;
//import java.util.zip.ZipOutputStream;
//
///*
//Разархивируем файл
//*/
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        Path path = Paths.get(args[0]);
//        List<Path> zipFiles = new ArrayList<>();
//        List<FileInputStream> fileInputStreams = new ArrayList<>();
//        for (int i = 1; i < args.length; i++) {
//            zipFiles.add(Paths.get(args[i]));
//        }
//        zipFiles.sort(new Comparator<Path>() {
//            @Override
//            public int compare(Path o1, Path o2) {
//                int o1_index_last_point = o1.toString().lastIndexOf(".")+1;
//                int o2_index_last_point = o2.toString().lastIndexOf(".")+1;
//                int o1_index = Integer.parseInt(o1.toString().substring(o1_index_last_point));
//                int o2_index = Integer.parseInt(o2.toString().substring(o2_index_last_point));
//                return o1_index - o2_index;
//            }
//        });
//        for (Path p:zipFiles) {
//            fileInputStreams.add(new FileInputStream(p.toString()));
//        }
//
//        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)))){
//            zipInputStream.getNextEntry();
//
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
//            Files.write(path,bufferedInputStream.readAllBytes());
//
//        }
//        }
//
//
//
//
//    }
//
package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File result = new File(args[0]);    //Файл результата, по совместительству имя этого файла мы ищем в архиве
        if (!result.exists()) {
            result.createNewFile();
        }
        List<FileInputStream> fileInputStreams = new ArrayList<>(); //Список входящих стримов из разных кусков архива

        //Расставляем имена файлов архива в нужном нам порядке
        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        //Создаем входящий стрим для каждого куска архива
        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }

        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams))))    //Входящий стрим общего архива
        {
            while (true) {
                ZipEntry entry = is.getNextEntry();
                if (entry == null) break;

                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(result))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                }
            }
        }
    }
}
