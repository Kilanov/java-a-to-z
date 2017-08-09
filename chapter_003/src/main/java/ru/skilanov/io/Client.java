package ru.skilanov.io;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Semen on 15.06.2017.
 */
public class Client {
    public static void main(String[] args) {
        int port = 5000;
        String ip = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            System.out.println("Connecting to " + port);
            Socket socket = new Socket(inetAddress, port);

            InputStream socketInput = socket.getInputStream();
            OutputStream socketOutput = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInput);
            DataOutputStream out = new DataOutputStream(socketOutput);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            System.out.println("Please input the message");

            while (true) {
                str = reader.readLine();
                if (str.equals("exit")){
                    break;
                }else {
                    out.writeUTF(str);
                    out.flush();
                    str = in.readUTF();
                    System.out.println("Oracl: " + str);
                    System.out.print("Me: ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
