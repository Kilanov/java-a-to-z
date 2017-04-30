package ru.skilanov.ioTest;

import org.junit.Test;
import ru.skilanov.io.ZipFile;

/**
 * This is test for ZipFile class.
 */
public class ZipFileTest {
    /**
     * This is test.
     */
    @Test
    public void whenWeSetDirectoryThenReturnZippedDirectory() {
        ZipFile zipFile = new ZipFile();
        try {
            zipFile.zipDirectory("c:\\projects\\java-a-to-z", "c:\\projects\\java-a-to-z.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
