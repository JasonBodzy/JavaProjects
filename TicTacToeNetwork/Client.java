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
            char character = ' ';
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
                //Read current move
                int currentMove = Integer.parseInt(clientReader.readLine());
                //Write new Move
                if (currentMove == playerNumber) {
                    if (row == -1 && column == -1) {
                        clientWriter.write(2 + "" + 2 + "" + "x");
                        clientWriter.println();
                        clientWriter.flush();
                    } else {
                        System.out.println("Writing move string");
                        clientWriter.write(row + "" + column + "" + character);
                        clientWriter.println();
                        clientWriter.flush();
                        row = -1;
                        column = -1;

                        //Read Board
                        int tracker = 0;
                        String boardString = clientReader.readLine();
                        for (int i = 0; i < board.length; i++) {
                            for (int j = 0; j < board[i].length; j++) {
                                board[i][j] = boardString.charAt(tracker);
                                tracker++;
                            }
                        }
                    }
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
