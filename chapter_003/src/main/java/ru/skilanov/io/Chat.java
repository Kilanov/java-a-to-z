package ru.skilanov.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is chat.
 */
public class Chat {

    /**
     * This is start method.
     *
     * @throws IOException exception
     */
    public void startIO() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            boolean exit = true;
            menu();
            label:
            do {
                switch (str) {
                    case "????":
                        chatIO();
                        break label;
                    case "??????????":
                        chatIO();
                        botRandom();
                        break label;
                    case "?????????":
                        break label;
                    default:
                        chatIO();
                        botRandom();
                        break;
                }
            } while (!exit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is menu.
     */
    public void menu() {
        System.out.println("Please input any word to start:"
                +
                "\n"
                +
                "1. Please enter 'стоп' to stop bot"
                + "\n"
                +
                "2. Please enter 'продолжить' to start bot"
                + "\n"
                +
                "3. Please enter 'закончить' to exit"
                + "\n");
    }

    /**
     * This is chat input method.
     */
    public void chatIO() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream outputStream = new FileOutputStream("test.txt", true);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
            String str = reader.readLine();
            printWriter.write(str);
            printWriter.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is chat output method.
     */
    public void botRandom() {
        ArrayList<String> list = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream("test2.txt");
             InputStreamReader streamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(streamReader);
             FileOutputStream outputStream = new FileOutputStream("test.txt", true);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {

            String lineTemp = reader.readLine();
            while (lineTemp != null) {
                list.add(lineTemp);
                lineTemp = reader.readLine();
                Collections.shuffle(list);
            }

            int itemIndex = (int) (Math.random() * list.size());
            System.out.println(list.get(itemIndex));
            printWriter.write(list.get(itemIndex));
            printWriter.write(System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

