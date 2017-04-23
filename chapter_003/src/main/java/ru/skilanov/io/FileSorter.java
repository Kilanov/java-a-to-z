package ru.skilanov.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class sorts file.
 */
public class FileSorter {

    /**
     * This method works with files.
     *
     * @param source   File
     * @param distance File
     * @throws IOException
     */
    public void sort(File source, File distance) {
        ArrayList<String> list = new ArrayList<>();
        try (RandomAccessFile reader = new RandomAccessFile(source, "r");
             RandomAccessFile writer = new RandomAccessFile(distance, "rw")) {
            try {
                String lineTemp = reader.readLine();
                while (lineTemp != null) {
                    list.add(lineTemp);
                    lineTemp = reader.readLine();
                }
                list = arraySorter(list);
                for (String tempString : list) {
                    writer.write(tempString.getBytes());
                    writer.write(System.lineSeparator().getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sorts array.
     *
     * @param list ArrayList
     * @return ArrayList
     */
    public ArrayList arraySorter(ArrayList list) {
        Collections.sort(list,
                new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                }
        );
        return list;
    }
}

