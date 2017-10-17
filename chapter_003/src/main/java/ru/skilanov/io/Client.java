package ru.skilanov.io;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * This is the socket client class.
 */
public class Client {

    /**
     * This is IP.
     */
    public static final String IP = "127.0.0.1";

    /**
     * This is port.
     */
    public static final int INT = 5000;

    /**
     * This is app dialog var.
     */
    public static final String CONNECTING_TO = "Connecting to ";

    /**
     * This is app dialog var.
     */
    public static final String PLEASE_INPUT_THE_MESSAGE = "Please input the message";

    /**
     * This is word for exit from app.
     */
    public static final String EXIT = "exit";

    /**
     * This is app dialog var.
     */
    public static final String ORACL = "Oracl: ";

    /**
     * This is app dialog var.
     */
    public static final String ME = "Me: ";

    /**
     * This is main method.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.clientAction();
    }

    /**
     * This is client method.
     */
    public void clientAction() {
        int port = INT;
        String ip = IP;

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            System.out.println(CONNECTING_TO + port);
            Socket socket = new Socket(inetAddress, port);

            InputStream socketInput = socket.getInputStream();
            OutputStream socketOutput = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInput);
            DataOutputStream out = new DataOutputStream(socketOutput);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            System.out.println(PLEASE_INPUT_THE_MESSAGE);

            while (true) {
                str = reader.readLine();
                if (str.equals(EXIT)) {
                    break;
                } else {
                    out.writeUTF(str);
                    out.flush();
                    str = in.readUTF();
                    System.out.println(ORACL + str);
                    System.out.print(ME);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
