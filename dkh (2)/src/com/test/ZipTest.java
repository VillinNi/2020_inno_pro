package com.test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    static void zipFile(String filepath, String zippath) throws IOException {
        File file = new File(filepath);
        File zipfile = new File(zippath);
        InputStream inputStream = new FileInputStream(file);
        ZipOutputStream zipOutputStream= new ZipOutputStream(new FileOutputStream(zipfile));
        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
        int temp=0;
        while((temp=inputStream.read())!=-1){
            zipOutputStream.write(temp);
        }
        inputStream.close();
        zipOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        String filepah="C:\\Users\\dkh\\Desktop\\aaa.txt";
        String zippath="C:\\Users\\dkh\\Desktop\\aaa.zip";
        zipFile(filepah, zippath);
    }
}
