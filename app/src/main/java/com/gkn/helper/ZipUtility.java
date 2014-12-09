package com.gkn.helper;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Girish K N on 09-Dec-14.
 */
public class ZipUtility {
    private static final String TAG = ZipUtility.class.getSimpleName();

    public static boolean UnCompress(String zipFilePath, String unzipPath) {
        try {
            Log.d(TAG, "Begin UnCompress.");
            FileInputStream fileInputStream = new FileInputStream(zipFilePath);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ZipEntry zipEntry;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(unzipPath + zipEntry.getName());
                for (int c = zipInputStream.read(); c != -1; zipInputStream.read()) {
                    fileOutputStream.write(c);
                }
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }

            zipInputStream.close();
            fileInputStream.close();
            Log.d(TAG, "UnCompress success.");
            return true;
        } catch (Exception e) {
            Log.d(TAG, "Exception e: " + e);
        }

        return false;
    }

    public static boolean unZip(String zipFile, String targetPath) {

        //create target location folder if not exist
        createDir(targetPath, "");

        try {
            FileInputStream fin = new FileInputStream(zipFile);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry ze = null;
            while ((ze = zin.getNextEntry()) != null) {

                //create dir if required while unzipping
                if (ze.isDirectory()) {
                    createDir(targetPath, ze.getName());
                } else {
                    FileOutputStream fout = new FileOutputStream(targetPath + ze.getName());
                    for (int c = zin.read(); c != -1; c = zin.read()) {
                        fout.write(c);
                    }

                    zin.closeEntry();
                    fout.close();
                }

            }
            zin.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private static void createDir(String path, String folder) {
        File f = new File(path + folder);
        if(!f.isDirectory()) {
            f.mkdirs();
        }
    }
}
