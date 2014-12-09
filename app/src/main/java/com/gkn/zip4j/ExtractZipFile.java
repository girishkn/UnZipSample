package com.gkn.zip4j;

import android.util.Log;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * Created by Girish K N on 09-Dec-14.
 */
public class ExtractZipFile {
    public static boolean extractZipFile(String zipFilePath, String unZipPath) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            zipFile.extractAll(unZipPath);
            return true;
        } catch (ZipException e) {
            e.printStackTrace();
        }
        return false;
    }
}
