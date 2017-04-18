package ru.skilanov.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.IOException;
/**
 * This class drops words.
 */
public class WordsDeleting {
    /**
     * This method drops words.
     *
     * @param in    InputStream
     * @param out   OutputStream
     * @param abuse String[]
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
             BufferedWriter outReader = new BufferedWriter(new OutputStreamWriter(out))) {
            while (inReader.ready()) {
                String inline = inReader.readLine();
                for (String str : abuse) {
                    inline = inline.replace(str, "");
                }
                outReader.write(inline);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
