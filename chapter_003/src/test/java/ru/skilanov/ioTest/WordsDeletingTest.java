package ru.skilanov.ioTest;

import org.junit.Test;
import ru.skilanov.io.WordsDeleting;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This is test for WordsDeleting class.
 */
public class WordsDeletingTest {
    /**
     * This method checking dropAbuse method.
     */
    @Test
    public void whenSetNumThenReturnTrue() {
        WordsDeleting deleting = new WordsDeleting();
        String checkingArray = "My name is Java";
        String[] abuse = {"a", "e", "y", "i"};
        String resultArray = "M nm s Jv";

        try (OutputStream outputStream = new ByteArrayOutputStream()) {
            deleting.dropAbuses(new ByteArrayInputStream(checkingArray.getBytes()), outputStream, abuse);
            assertThat(resultArray, is(outputStream.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
