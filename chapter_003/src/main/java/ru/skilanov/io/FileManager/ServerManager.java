package ru.skilanov.io.fileManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;



/**
 * This is socket server file manager class.
 */
public class ServerManager {
    /**
     * This is constant param.
     */
    public static final String PROP = "C:\\projects\\java-a-to-z\\chapter_003\\src\\main\\java\\ru\\"
            + "skilanov\\io\\fileManager\\config.properties";
    /**
     * This is constant param.
     */
    public static final int NULL = 0;
    /**
     * This is constant param.
     */
    public static final int FOUR = 4;
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
    public static final String PLEASE_INPUT_FILE_NAME_FOR_OPEN = "Please input file name for open";
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
    public static final String PARENTS_DIRECTORY = "parentsDirectory";
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
    private UserAction[] actions = new UserAction[FIVE];

    /**
     * This constructor gets class params.
     *
     * @param in  DataInputStream
     * @param out DataOutputStream
     */
    public ServerManager(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * This is main method.
     *
     * @param args String[]
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream(PROP);
        Properties properties = new Properties();
        properties.load(in);
        String port = properties.getProperty(PORT);
        Socket socket = new ServerSocket(Integer.parseInt(port)).accept();

        InputStream socketInputStream = socket.getInputStream();
        OutputStream socketOutputStream = socket.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(socketInputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(socketOutputStream);
        ServerManager server = new ServerManager(dataInputStream, dataOutputStream);
        server.fillActions();
        int key = NULL;
        while (FOUR != key) {
            server.show();
            String str = dataInputStream.readUTF();
            key = Integer.parseInt(str);
            server.select(key);
        }
    }

    /**
     * This method fill menu points.
     */
    public void fillActions() {
        this.actions[NULL] = new ParentsDirectory(PLEASE_CHOOSE_FOR_SHOW_DIRECTORY);
        this.actions[ONE] = new SubDirectory(PLEASE_INPUT_SUB_DIR);
        this.actions[TWO] = new ShowFile(PLEASE_INPUT_FILE_NAME_FOR_OPEN);
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
            try {
                FileInputStream in = new FileInputStream(PROP);
                Properties properties = new Properties();
                properties.load(in);
                String parentsDirectory = properties.getProperty(PARENTS_DIRECTORY);
                while (true) {
                    File file = new File(parentsDirectory);
                    File[] list = file.listFiles();
                    String fileToString = Arrays.toString(list);
                    out.writeUTF(fileToString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This class shows sub directory.
     */
    public class SubDirectory extends BaseAction {

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
                String str = in.readUTF();
                FileInputStream in = new FileInputStream(PROP);
                Properties properties = new Properties();
                properties.load(in);
                String parentsDirectory = properties.getProperty(PARENTS_DIRECTORY);

                String subDir = parentsDirectory + "//" + str;
                File file = new File(subDir);
                File[] list = file.listFiles();
                String fileToString = Arrays.toString(list);

                out.writeUTF(fileToString);
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
            try {
                String str = in.readUTF();
                FileInputStream in = new FileInputStream(PROP);
                Properties properties = new Properties();
                properties.load(in);
                String parentsDirectory = properties.getProperty(PARENTS_DIRECTORY);
                String path = parentsDirectory + "//" + str;
                File f = new File(path);
                BufferedReader fin = new BufferedReader(new FileReader(f));
                String line = null;
                while ((line = fin.readLine()) != null) {
                    out.writeUTF(line);
                    out.flush();
                }
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
        public static final String SUCCESSFUL = "Successful";

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
                String fileName = in.readUTF();
                String newPath = in.readUTF();
                String newFileName = in.readUTF();
                FileInputStream in = new FileInputStream(PROP);
                Properties properties = new Properties();
                properties.load(in);
                String parentsDirectory = properties.getProperty(PARENTS_DIRECTORY);
                File originalFile = new File(parentsDirectory, fileName);
                File newFile = new File(newPath, newFileName);
                originalFile.renameTo(newFile);
                out.writeUTF(SUCCESSFUL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
