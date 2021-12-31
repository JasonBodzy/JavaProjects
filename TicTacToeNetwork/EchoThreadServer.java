import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoThreadServer extends Thread {
    int playerNum;
    Socket socket;

    public EchoThreadServer(Socket socket, int playerNum) {
        this.socket = socket;
        this.playerNum = playerNum;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println(this.playerNum);
            writer.write(String.valueOf(this.playerNum));
            writer.println();
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
