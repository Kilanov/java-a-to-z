package ru.skilanov.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class check num parity.
 */
public class ParityChecker {

    /**
     * This class check parity.
     *
     * @param in int
     * @return false
     */
    public boolean isNumber(InputStream in) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            int num = Integer.parseInt(reader.readLine());

            if (num % 2 == 0) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
