package ru.skilanov.io;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the socket server class.
 */
public class Server {

    /**
     * This is constant variable for port.
     */
    public static final int PORT_NUMBER = 5000;
    /**
     * This is app dialog var.
     */
    public static final String LOOKING_FORWARD_TO_CONNECTION = "Looking forward to connection";
    /**
     * This is app dialog var.
     */
    public static final String DONE = "Done";
    /**
     * This is file.
     */
    public static final String D_FILE_TXT = "D:/file.txt";
    /**
     * This is app dialog var.
     */
    public static final String MESSAGE_FROM_USER = "Message from user: ";
    /**
     * This is app dialog var.
     */
    public static final String SENDING_AN_ANSWER = "Sending an answer ";

    /**
     * This is constant.
     */
    private final Socket socket;

    /**
     * This is constructor.
     *
     * @param socket Socket
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * This is main method.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            Socket socket = new ServerSocket(PORT_NUMBER).accept();
            Server server = new Server(socket);
            server.serverAction();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This is server method.
     */
    public void serverAction() {
        try {
            Random random = new Random();

            InputStream socketInput = socket.getInputStream();
            OutputStream socketOutput = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInput);
            DataOutputStream out = new DataOutputStream(socketOutput);

            List<String> wordsList = new ArrayList<>();
            FileInputStream fStream = new FileInputStream(D_FILE_TXT);
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
            String s;
            while ((s = br.readLine()) != null) {
                wordsList.add(s);
            }

            while (true) {
                String str = in.readUTF();
                System.out.println(MESSAGE_FROM_USER + str);
                System.out.println(SENDING_AN_ANSWER);
                out.writeUTF(wordsList.get(random.nextInt(wordsList.size())));
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
