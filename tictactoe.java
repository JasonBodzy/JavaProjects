import java.util.Scanner;

public class tictactoe {
    tictactoe(){

    }

    void printGameBoard(String[] board){ //Prints the current game board
        int i = 0;
        for(String s : board){
            if(i == 0 || i == 1){
                System.out.print(s + "|");
                i++;
            }else if(i == 2){
                System.out.print(s + "\n");
                i = 0;
            }

        }
        System.out.println("\n");
    }

    String gameOverCheck(String[] board){ //Checks if the game is over and returns the winner if applicable

        if(board[0] == board[1] && board[0] ==  board[2]){
            if(board[0] == "x"){
                return("x");
            }
            if(board[0] == "o"){
                return("o");
            }
        }
        if(board[0] == board[3] && board[0] ==  board[6]){
            if(board[0] == "x"){
                return("x");
            }
            if(board[0] == "o"){
                return("o");
            }
        }
        if(board[3] == board[4] && board[4] ==  board[5]){
            if(board[4] == "x"){
                return("x");
            }
            if(board[4] == "o"){
                return("o");
            }
        }
        if(board[1] == board[4] && board[1] ==  board[7]){
            if(board[1] == "x"){
                return("x");
            }
            if(board[1] == "o"){
                return("o");
            }
        }
        if(board[6] == board[7] && board[7] ==  board[8]){
            if(board[7] == "x"){
                return("x");
            }
            if(board[7] == "o"){
                return("o");
            }
        }
        if(board[2] == board[5] && board[5] ==  board[8]){
            if(board[2] == "x"){
                return("x");
            }
            if(board[2] == "o"){
                return("o");
            }
        }
        if(board[0] == board[4] && board[4] ==  board[8]){
            if(board[0] == "x"){
                return("x");
            }
            if(board[0] == "o"){
                return("o");
            }
        }
        if(board[2] == board[4] && board[4] ==  board[6]){
            if(board[2] == "x"){
                return("x");
            }
            if(board[2] == "o"){
                return("o");
            }
        }
        return("none");
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        tictactoe t = new tictactoe();

        String[] gameBoard = {" ", " ", " ", " ", " ", " ", " ", " ", " "}; //Clear board
        boolean gameOver = false;
        boolean xTurn = true;

        System.out.println("Welcome to Tic-Tac-Toe");
        t.printGameBoard(gameBoard);

        while(!gameOver){ //main game loop
            if(xTurn){
                System.out.println("x, enter a number 1-9 to select your spot");
                int xMove = s.nextInt();
                s.nextLine();

                if(gameBoard[xMove - 1] == " " && xMove - 1 >= 0 && xMove - 1 <= 8){
                    gameBoard[xMove - 1] = "x";
                }else{
                    System.out.println("Invalid move!");
                }
                t.printGameBoard(gameBoard);
                if(!t.gameOverCheck(gameBoard).equals("none")){
                    System.out.println(t.gameOverCheck(gameBoard) + " wins!");
                    gameOver = true;
                    break;
                }
                xTurn = false;
            }
            if(!xTurn){
                System.out.println("o, enter a number 1-9 to select your spot");
                int oMove = s.nextInt();
                s.nextLine();

                if(gameBoard[oMove - 1] == " " && oMove - 1 >= 0 && oMove - 1 <= 8){
                    gameBoard[oMove - 1] = "o";
                }else{
                    System.out.println("Invalid move!");
                }
                t.printGameBoard(gameBoard);
                if(!t.gameOverCheck(gameBoard).equals("none")){
                    System.out.println(t.gameOverCheck(gameBoard) + " wins!");
                    gameOver = true;
                    break;
                }
                xTurn = true;
            }



        }





    }

}
