package ru.skilanov.ioTest;

import org.junit.Assert;
import org.junit.Test;
import ru.skilanov.io.FileSorter;

import java.io.File;

/**
 * This is test for FileSorter class.
 */
public class FileSorterTest {
    /**
     * This is test that compares two files.
     */
    @Test
    public void whenWeSortFileThenReturnSortedFile() {
        File source = new File("D:\\test.txt");
        File distance = new File("D:\\test2.txt");
        FileSorter fs = new FileSorter();
        fs.sort(source, distance);

        Assert.assertFalse(source.equals(distance));
    }
}
