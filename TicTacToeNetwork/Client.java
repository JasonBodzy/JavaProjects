import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends ClientGUI implements Runnable {

    private static Socket clientSocket;
    private GameManager gameManager = new GameManager();

    ClientGUI clientGUI = new ClientGUI();
    public GameManager getGameManager() {
        return this.gameManager;
    }

    private static Socket connectToServer() {
        try {
            clientSocket = new Socket("localhost", 4242);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return clientSocket;
    }

    private void protocol() {
        try {
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream());
            String playerNum = clientReader.readLine();
            System.out.println("Player " + playerNum);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setup() {
        clientSocket = connectToServer();
        protocol();
        SwingUtilities.invokeLater(new Client());
    }




}
