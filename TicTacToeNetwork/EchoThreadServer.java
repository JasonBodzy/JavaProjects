import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoThreadServer extends Thread {
    int playerNum;
    Socket socket;
    GameManager gameManager;

    public EchoThreadServer(Socket socket, int playerNum, GameManager gameManager) {
        this.socket = socket;
        this.playerNum = playerNum;
        this.gameManager = gameManager;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            writer.write(String.valueOf(this.playerNum));
            writer.println();
            writer.flush();

            do {
                //Write winner
                System.out.println("winner" + String.valueOf(gameManager.determineWinner()));
                writer.write(String.valueOf(gameManager.determineWinner()));
                writer.println();
                writer.flush();

                //Write boardString
                char[][] board = gameManager.getBoard();
                String boardString = "";
                for (char[] C : board) {
                    for (char c : C) {
                        boardString += c;
                    }
                }
                writer.write(boardString);
                writer.println();
                writer.flush();

                //Write current move
                writer.write(String.valueOf(gameManager.getCurrentMove()));
                writer.println();
                writer.flush();

                //Read new move
                String newMove = "null";
                newMove = reader.readLine();
                while(newMove.equals("null")) {
                    newMove = reader.readLine();
                }

                if (!(newMove.equals("pass"))){
                    gameManager.updateBoard(newMove);
                }


            } while (gameManager.determineWinner() == 0);

            System.out.println("Winner!!");
            System.out.println(gameManager.determineWinner());
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
