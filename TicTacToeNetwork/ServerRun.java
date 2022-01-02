import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRun {


    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(4242);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 3; i++) {
            try {
                socket = serverSocket.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            new EchoThreadServer(socket, i, gameManager).start();
        }


    }

}
