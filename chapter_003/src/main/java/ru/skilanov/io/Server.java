package ru.skilanov.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Semen on 15.06.2017.
 */
public class Server {
    public static void main(String[] args) {
        int port = 5000;
        try {
            Random random = new Random();
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("looking for connection");
            Socket socket = serverSocket.accept();
            System.out.println("Done");

            InputStream socketInput = socket.getInputStream();
            OutputStream socketOutput = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInput);
            DataOutputStream out = new DataOutputStream(socketOutput);

            List<String> wordsList = new ArrayList<>();
            FileInputStream fstream = new FileInputStream("D:/file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String s;
            while((s = br.readLine()) != null) {
                wordsList.add(s);
            }

            while (true) {
                String str = str = in.readUTF();
                System.out.println("Message from user: " + str);
                System.out.println("Sending an answer ");
                out.writeUTF(wordsList.get(random.nextInt(wordsList.size())));
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
