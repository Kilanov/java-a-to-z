package ru.skilanov.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is chat.
 */
public class Chat {

    /**
     * This is start method.
     *
     */
    public void startIO() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            menu();

            while (true) {
                String str = reader.readLine();
                if (str.equals("стоп")) {
                    chatIO();
                } else if ((str.equals("продолжить"))) {
                    chatIO();
                    botRandom();
                } else if (str.equals("закончить")) {
                    break;
                }
                chatIO();
                botRandom();
            }

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
     * @throws IOException exception
     */
    public void chatIO() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream("test.txt", true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);
        String str = reader.readLine();
        printWriter.write(str);
        printWriter.write(System.lineSeparator());
    }


    /**
     * This is chat output method.
     * @throws IOException exception
     */
    public void botRandom() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream("test2.txt");
        InputStreamReader streamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        FileOutputStream outputStream = new FileOutputStream("test.txt", true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

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
    }
}

