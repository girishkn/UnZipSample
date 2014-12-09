package com.gkn.helper;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * Created by Girish K N on 09-Dec-14.
 */
public class ExtractZipFileUsingZip4j {
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
