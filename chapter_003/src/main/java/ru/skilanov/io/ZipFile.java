package ru.skilanov.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class compress directory to zip file..
 */
public class ZipFile {
    /**
     * This is const.
     */
    public static final int INT = 1024;

    /**
     * This method makes zip file.
     *
     * @param srcDirectory String
     * @param destZipFile  String
     */
    public void zipDirectory(String srcDirectory, String destZipFile) {
        try (FileOutputStream fileWriter = new FileOutputStream(destZipFile);
             ZipOutputStream zip = new ZipOutputStream(fileWriter)) {
            addDirectoryToZip("", srcDirectory, zip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds file to zip.
     *
     * @param path    String
     * @param srcFile String
     * @param zip     ZipInputStream
     */
    public void addFileToZip(String path, String srcFile, ZipOutputStream zip) {

        File folder = new File(srcFile);
        if (folder.isDirectory()) {
            try {
                addDirectoryToZip(path, srcFile, zip);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            byte[] buf = new byte[INT];
            int len;
            try (FileInputStream in = new FileInputStream(srcFile)) {
                zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
                while ((len = in.read(buf)) > 0) {
                    zip.write(buf, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method adds directory to zip.
     *
     * @param path         String
     * @param srcDirectory String
     * @param zip          ZipOutputStream
     */
    public void addDirectoryToZip(String path, String srcDirectory, ZipOutputStream zip) {
        File directory = new File(srcDirectory);
        for (String fileName : directory.list()) {
            if (path.equals("")) {
                addFileToZip(directory.getName(), srcDirectory + "/" + fileName, zip);
            } else {
                addFileToZip(path + "/" + directory.getName(), srcDirectory + "/" + fileName, zip);
            }
        }
    }
}
