import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket;
    private int playerNumber;
    private char character;
    private int currentMove;

    private int row = -1;
    private int column = -1;

    private char[][] board = new char[][]{{'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}};;

    public void setRowAndColumn(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public char[][] getBoard() {
        return this.board;
    }

    public char getCharacter() {
        return this.character;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public int getCurrentMove() {
        return this.currentMove;
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

    private void readBoardString(BufferedReader clientReader) throws Exception {
        //Read BoardString
        int tracker = 0;
        String boardString = clientReader.readLine();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = boardString.charAt(tracker);
                tracker++;
            }
        }
    }

    private void protocol() {
        try {

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream());
            character = ' ';
            String playerNum = clientReader.readLine();
            playerNumber = Integer.parseInt(playerNum);
            System.out.println("Player " + playerNumber);

            if (playerNumber == 1) {
                character = 'x';
            } else if (playerNumber == 2) {
                character = 'o';
            }

            int winner = 0;

            do {
                //Read winner
                winner = Integer.parseInt(clientReader.readLine());
                // Read board string
                readBoardString(clientReader);
                //Read current move
                currentMove = Integer.parseInt(clientReader.readLine());
                //While not current move
                while(playerNumber != currentMove) {
                    clientWriter.write("pass");
                    clientWriter.println();
                    clientWriter.flush();
                    winner = Integer.parseInt(clientReader.readLine());
                    readBoardString(clientReader);
                    currentMove = Integer.parseInt(clientReader.readLine());
                }
                //Write new Move
                if (currentMove == playerNumber) {
                    while (row == -1 && column == -1) {
                        clientWriter.write("null");
                        clientWriter.println();
                        clientWriter.flush();
                    }
                    clientWriter.write(row + "" + column + "" + character);
                    clientWriter.println();
                    clientWriter.flush();
                    row = -1;
                    column = -1;
                }

            } while (winner == 0);

            System.out.println("winner");

            clientWriter.close();
            clientReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setup() {
        clientSocket = connectToServer();
        protocol();
    }




}
