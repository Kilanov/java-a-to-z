package ru.skilanov.io.fileManager;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

/**
 * This is socket client file manager class.
 */
public class ClientManager {
    /**
     * This is constant param.
     */
    public static final String PROP = "src\\main\\java\\ru\\skilanov\\io\\fileManager\\resources\\config.properties";
    /**
     * This is constant param.
     */
    public static final String MENU_POINT = "Please choose 0 for return to the parents directory and exit for stop";
    /**
     * This is constant param.
     */
    public static final String EXIT = "exit";
    /**
     * This is constant param.
     */
    public static final int NULL = 0;
    /**
     * This is constant param.
     */
    public static final int ONE = 1;
    /**
     * This is constant param.
     */
    public static final int TWO = 2;
    /**
     * This is constant param.
     */
    public static final int THREE = 3;
    /**
     * This is constant param.
     */
    public static final String PLEASE_CHOOSE_FOR_SHOW_DIRECTORY = "Please choose for show directory";
    /**
     * This is constant param.
     */
    public static final String PLEASE_INPUT_SUB_DIR = "Please input subDir";
    /**
     * This is constant param.
     */
    public static final String PLEASE_INPUT_FILE_NAME = "Please input file name";
    /**
     * This is constant param.
     */
    public static final String PLEASE_INPUT_FILE_FOR_DOWNLOAD = "Please input file for download";
    /**
     * This is constant param.
     */
    public static final String PORT = "port";
    /**
     * This is constant param.
     */
    public static final String IP_ADDRESS = "ipAddress";
    /**
     * This is constant param.
     */
    public static final int FIVE = 5;
    /**
     * This is constant param.
     */
    private final DataInputStream in;
    /**
     * This is constant param.
     */
    private final DataOutputStream out;
    /**
     * This is constant param.
     */
    private final BufferedReader reader;
    /**
     * This is constant param.
     */
    private UserAction[] actions = new UserAction[FIVE];

    /**
     * This constructor gets class params.
     *
     * @param in     DataInputStream
     * @param out    DataOutputStream
     * @param reader BufferedReader
     */
    public ClientManager(DataInputStream in, DataOutputStream out, BufferedReader reader) {
        this.in = in;
        this.out = out;
        this.reader = reader;
    }

    /**
     * This is main method.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(PROP)) {
            Properties properties = new Properties();
            properties.load(in);
            String port = properties.getProperty(PORT);
            String ipAddress = properties.getProperty(IP_ADDRESS);

            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            Socket socket = new Socket(inetAddress, Integer.parseInt(port));

            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStream = socket.getOutputStream();

            DataInputStream inputStream = new DataInputStream(socketInputStream);
            DataOutputStream outputStream = new DataOutputStream(socketOutputStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            ClientManager clientManager = new ClientManager(inputStream, outputStream, reader);
            String str = null;

            clientManager.fillActions();
            do {
                clientManager.show();
                System.out.println(MENU_POINT);
                str = reader.readLine();
                if (str.equals(EXIT)) {
                    break;
                } else {
                    outputStream.writeUTF(str);
                    int key = Integer.parseInt(str);
                    clientManager.select(key);
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method fill menu points.
     */

    public void fillActions() {
        this.actions[NULL] = new ParentsDirectory(PLEASE_CHOOSE_FOR_SHOW_DIRECTORY);
        this.actions[ONE] = new SubDirectory(PLEASE_INPUT_SUB_DIR);
        this.actions[TWO] = new ShowFile(PLEASE_INPUT_FILE_NAME);
        this.actions[THREE] = new DownloadFile(PLEASE_INPUT_FILE_FOR_DOWNLOAD);
    }

    /**
     * This class shows menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * This method selects an action.
     *
     * @param key int
     */
    public void select(int key) {
        try {
            this.actions[key].execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This class shows parents directory.
     */
    public class ParentsDirectory extends BaseAction {

        /**
         * This is constant param.
         */
        public static final int NULL = 0;

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public ParentsDirectory(String name) {
            super(name);
        }

        /**
         * This method makes position of menu point.
         *
         * @return 0
         */
        @Override
        public int key() {
            return NULL;
        }

        /**
         * This method shows directory.
         */
        @Override
        public void execute() {
            String str = null;
            try {
                str = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        }
    }

    /**
     * This class shows sub directory.
     */
    public class SubDirectory extends BaseAction {

        /**
         * This is constant param.
         */
        public static final int ONE = 1;
        /**
         * This is constant param.
         */
        public static final String PLEASE_INPUT_SUB_DIRECTORY = "Please input sub directory: ";

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public SubDirectory(String name) {
            super(name);
        }

        /**
         * This method makes position of menu point.
         *
         * @return 1
         */
        @Override
        public int key() {
            return ONE;
        }

        /**
         * This method shows sub directory.
         */
        @Override
        public void execute() {
            try {
                System.out.print(PLEASE_INPUT_SUB_DIRECTORY);
                String str = reader.readLine();
                out.writeUTF(str);
                System.out.println(str);
                String str2 = in.readUTF();
                System.out.println(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This class shows file.
     */
    public class ShowFile extends BaseAction {

        /**
         * This is constant param.
         */
        public static final int TWO = 2;
        /**
         * This is constant param.
         */
        public static final String PLEASE_INPUT_FILE = "Please input file: ";

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public ShowFile(String name) {
            super(name);
        }

        /**
         * This method makes position of menu point.
         *
         * @return 2
         */
        @Override
        public int key() {
            return TWO;
        }

        /**
         * This method shows file.
         */
        @Override
        public void execute() {
            System.out.print(PLEASE_INPUT_FILE);
            try {
                String str = reader.readLine();
                out.writeUTF(str);
                System.out.println(str);
                System.out.println(in.readUTF());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This class downloads file.
     */
    public class DownloadFile extends BaseAction {

        /**
         * This is constant param.
         */
        public static final int THREE = 3;
        /**
         * This is constant param.
         */
        public static final String PLEASE_INPUT_FILE_NAME = "Please input file name: ";
        /**
         * This is constant param.
         */
        public static final String PLEASE_INPUT_DIRECTORY_FOR_DOWNLOAD = "Please input directory for download: ";
        /**
         * This is constant param.
         */
        public static final String PLEASE_INPUT_NEW_FILE_NAME = "Please input new file name: ";

        /**
         * This is abstract class constructor.
         *
         * @param name String
         */
        public DownloadFile(String name) {
            super(name);
        }

        /**
         * This method makes position of menu point.
         *
         * @return 3
         */
        @Override
        public int key() {
            return THREE;
        }

        /**
         * This method downloads file.
         */
        @Override
        public void execute() {
            try {
                System.out.print(PLEASE_INPUT_FILE_NAME);
                String fileName = reader.readLine();
                System.out.print(PLEASE_INPUT_DIRECTORY_FOR_DOWNLOAD);
                String downloadDirectory = reader.readLine();
                System.out.print(PLEASE_INPUT_NEW_FILE_NAME);
                String newFileName = reader.readLine();
                out.writeUTF(fileName);
                out.writeUTF(downloadDirectory);
                out.writeUTF(newFileName);
                System.out.println(in.readUTF());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

