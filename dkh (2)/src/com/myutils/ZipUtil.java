package com.myutils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
    public static File doZip(String exam_name)
            throws IOException {
        String sourceDir = "/WEB-INf/upload/exam_answer/"+exam_name;
        String zipFilePath=sourceDir+".zip";
        File file = new File(sourceDir);
        File zipFile = new File(zipFilePath);
        ZipOutputStream zos = null;
        if(zipFile.exists())
            zipFile.delete();
        try {
            // 创建写出流操作
            OutputStream os = new FileOutputStream(zipFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            zos = new ZipOutputStream(bos);

            // 获取目录
            String basePath = null;
            if (file.isDirectory()) {
                basePath = file.getPath();
            } else {
                basePath = file.getParent();
            }
            zipFile(file, basePath, zos);
        } finally {
            if (zos != null) {
                zos.closeEntry();
                zos.close();
            }
        }
        return zipFile;
    }

    private static void zipFile(File source, String basePath,
                                ZipOutputStream zos) throws IOException {
        File[] files = null;
        if (source.isDirectory()) {
            files = source.listFiles();
        } else {
            files = new File[1];
            files[0] = source;
        }

        InputStream is = null;
        String pathName;
        byte[] buf = new byte[1024];
        int length = 0;
        try {
            for (File file : files) {
                if (file.isDirectory()) {
                    pathName = file.getPath().substring(basePath.length() + 1) + "/";
                    zos.putNextEntry(new ZipEntry(pathName));
                    zipFile(file, basePath, zos);
                } else {
                    pathName = file.getPath().substring(basePath.length() + 1);
                    is = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    zos.putNextEntry(new ZipEntry(pathName));
                    while ((length = bis.read(buf)) > 0) {
                        zos.write(buf, 0, length);
                    }
                    bis.close();
                }
            }
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
